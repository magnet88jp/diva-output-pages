package models;

import javax.persistence.Entity;
import play.db.jpa.Model;

@Entity
public class Page extends Model {
  public String subject;
  public String description;

  public Page(String subject, String description) {
    this.subject = subject;
    this.description= description;
  }

  public String toString() {
    return subject;
  }
}
