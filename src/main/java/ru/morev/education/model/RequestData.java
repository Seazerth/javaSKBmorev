package ru.morev.education.model;

public class RequestData {
    private Double price;
    private Info info;

    public static class Info {
        private String date;

        public String getDate() { return date; }
        public void setDate(String date) { this.date = date; }
    }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Info getInfo() { return info; }
    public void setInfo(Info info) { this.info = info; }
}
