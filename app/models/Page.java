package models;

import javax.persistence.*;
import play.db.jpa.Model;
import play.data.validation.*;

@Entity
public class Page extends Model {
  public String subject;
  @Lob
  @MaxSize(4000)
  public String description;

  public Page(String subject, String description) {
    this.subject = subject;
    this.description= description;
  }

  public String toString() {
    return subject;
  }
}
