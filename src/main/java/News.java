import org.sql2o.Connection;

import java.util.Objects;

public class News implements DatabaseManagement{
    private int id;
    private String text;

    public News (String text){
        this.id=id;
        this.text=text;

    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return id == news.id && Objects.equals(text, news.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text);
    }

    @Override
    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO news (text) VALUES (:text)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.text)
                    .executeUpdate()
                    .getKey();
        }

    }
}
