package ru.morev.education.model;

public class ResponseData {
    private Double price;
    private Info info;

    public static class Info {
        private Long id;
        private String date;

        public Long getId() { return id; }
        public void setId(Long id) { this.id = id; }

        public String getDate() { return date; }
        public void setDate(String date) { this.date = date; }
    }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Info getInfo() { return info; }
    public void setInfo(Info info) { this.info = info; }
}
