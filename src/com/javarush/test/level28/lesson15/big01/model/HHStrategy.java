package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dima on 20.01.2016.
 */
public class HHStrategy implements Strategy
{
    private static final String URL_FORMAT= "http://hh.ua/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        List<Vacancy>vacancies=new ArrayList<>();
        try
        {
            for (int i=0; true; i++)
            {
                Elements elements = getDocument(searchString, i).select("[data-qa=vacancy-serp__vacancy]");
                if (elements.size() == 0) break;
                for (Element element : elements)
                {
                    Vacancy vac=new Vacancy();
                    vac.setTitle(element.select("[data-qa=\"vacancy-serp__vacancy-title\"]").text());
                    vac.setCompanyName(element.select("[data-qa=\"vacancy-serp__vacancy-employer\"]").text());
                    vac.setCity(element.select("[data-qa=\"vacancy-serp__vacancy-address\"]").text());
                    vac.setSiteName("http://hh.ua/");
                    vac.setUrl(element.select("[data-qa=\"vacancy-serp__vacancy-title\"]").attr("href"));
                    Element salaryElement = element.select("[data-qa=vacancy-serp__vacancy-compensation]").first();
                    String salary = "";
                    if (salaryElement != null)
                    {
                        salary = salaryElement.text();
                    }
                    vac.setSalary(salary);
                    vacancies.add(vac);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException{
        String refferer="http://hh.ua/search/vacancy?text=java+%D0%9A%D0%B8%D0%B5%D0%B2&area=0";
        String userAgent="Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.85 Safari/537.36";
       return Jsoup.connect(String.format(URL_FORMAT, searchString,page)).userAgent(userAgent).referrer(refferer).get();
    }
}
