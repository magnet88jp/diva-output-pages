package jobs;

import java.util.*;
import java.io.*;
import play.*;
import play.jobs.*;
import play.templates.*;
import models.*;

public class OutputPages extends Job {

  public void doJob() {
    Template template = TemplateLoader.load("conf/templates/page.rst");
    List<Page> pages = Page.findAll();
    for(Page page : pages) {
      Map<String, Object> map = new HashMap<String, Object>(16);
      map.put("id", page.id);
      map.put("subject", page.subject);
      map.put("description", page.description);
      String text = template.render(map);
      try {
        FileWriter fw = new FileWriter("doc/source/pages/" + page.id + ".rst");
        fw.write(text);
        fw.close();
      } catch (IOException e) {
        Logger.error(e, e.getMessage());
      } finally {
      }
    }
  }
}
