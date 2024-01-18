package de.telran.hw002Books;
import lombok.*;

@Getter
@Setter
@ToString

public class Book {
        private String author;
        private String name;
        private int issueYear;
        private Condition condition;
        private boolean isEBOOK;

        public Book(String author, String name, int issueYear, Condition condition, boolean isEBOOK) {
            this.author = author;
            this.name = name;
            this.issueYear = issueYear;
            this.condition = condition;
            this.isEBOOK = isEBOOK;
        }

    public boolean isEBOOK() {
        return isEBOOK;
    }
    public int getIssueYear() {
        return issueYear;
    }
    public Condition getCondition() {
        return condition;
    }
    public String getAuthor() {
        return author;
    }
    public String getName() {
        return name;
    }
}
