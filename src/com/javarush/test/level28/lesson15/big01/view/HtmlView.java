package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.util.List;

/**
 * Created by Dima on 20.01.2016.
 */
public class HtmlView implements View
{
    private Controller controller;
    private final String filePath="./src/" + this.getClass().getPackage().getName().replace(".", "/") + "/vacancies.html";


    @Override
    public void update(List<Vacancy> vacancies)
    {
        try {
            String newVacanciesFileHtml = getUpdatedFileContent(vacancies);
            updateFile(newVacanciesFileHtml);
        } catch (IOException e){
            e.printStackTrace();
            System.out.println("Some exception occurred");
        }
    }

    @Override
    public void setController(Controller controller)
    {
      this.controller=controller;
    }

    public void userCitySelectEmulationMethod(){
        controller.onCitySelect("Москва");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) throws IOException
    {

        Document document=getDocument();
        Element originalElement=document.getElementsByClass("template").first();
        Element templateElement = originalElement.clone();
        templateElement.removeClass("template").addClass("vacancy").removeAttr("style");
        document.select("tr[class*=\"vacancy\"]").not("tr[class=\"vacancy template\"]").remove();
        for (Vacancy vacancy:vacancies){
                Element pattern = templateElement.clone();
                pattern.getElementsByAttributeValue("class", "city").get(0).text(vacancy.getCity());
                pattern.getElementsByAttributeValue("class", "companyName").get(0).text(vacancy.getCompanyName());
                pattern.getElementsByAttributeValue("class", "salary").get(0).text(vacancy.getSalary());
                pattern.getElementsByAttribute("href").get(0).text(vacancy.getTitle()).attr("href", vacancy.getUrl());
                originalElement.before(pattern.outerHtml());
        }
        return document.html();
    }

    private void updateFile(String fileContent){
        try
        {
            FileWriter pw=new FileWriter(filePath);
            pw.write(fileContent);
            pw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    protected Document getDocument() throws IOException{
        File file=new File(filePath);
        return Jsoup.parse(file, "UTF-8");
    }


}
