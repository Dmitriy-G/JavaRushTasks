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
 * Created by Dima on 21.01.2016.
 */
public class MoikrugStrategy implements Strategy
{
    private static final String URL_FORMAT= "https://moikrug.ru/vacancies?q=java+%s&page=%d";
    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        List<Vacancy> vacancies = new ArrayList<>();
        Document doc = null;
        int i = 1;
        while (true)
        {
            try
            {
                doc = getDocument(searchString,i++);
            }
            catch (IOException e)
            {
            }
            Elements elements =doc.getElementsByClass("job");
            if (!elements.isEmpty())
            {
                for (Element e : elements)
                {
                    Vacancy vacancy = new Vacancy();
                    vacancy.setUrl("https://moikrug.ru"+e.getElementsByClass("title").select("a").attr("href"));
                    vacancy.setTitle(e.getElementsByClass("title").text());
                    vacancy.setCity(e.getElementsByClass("location").text());
                    vacancy.setCompanyName(e.getElementsByClass("company_name").select("a[href]").text());
                    vacancy.setSalary(e.getElementsByClass("count").text());
                    vacancy.setSiteName(doc.title());
                    vacancies.add(vacancy);
                }
            }
            else break;
        }
        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException{
        String refferer="https://moikrug.ru";
        String userAgent="Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.85 Safari/537.36";
        return Jsoup.connect(String.format(URL_FORMAT, searchString, page)).userAgent(userAgent).referrer(refferer).get();
    }
}
