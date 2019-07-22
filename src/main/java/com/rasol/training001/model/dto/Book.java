package com.rasol.training001.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rasol.training001.externelservice.dto.NaverBook;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Book {
    private String title;
    private String contents;
    private String isbn;
    @JsonProperty("datetime")
    private String dateTime;
    private List<String> authors;
    private String publisher;
    private Integer price;
    @JsonProperty("sale_price")
    private Integer salePrice;
    private String thumbnail;

    public Book(){

    }

    public Book(NaverBook naverBook){
        this.setTitle(naverBook.getTitle());
        this.setContents(naverBook.getContents());
        this.setIsbn(naverBook.getIsbn());

        SimpleDateFormat sourceDateFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat resultDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        Date date;
        try {
            date = sourceDateFormat.parse(naverBook.getDateTime());
            setDateTime(resultDateFormat.format(date));
        }catch(Exception e){
            e.printStackTrace();
            setDateTime(naverBook.getDateTime());
        }
        this.setAuthors(Arrays.stream(naverBook.getAuthors().split("\\|")).collect(Collectors.toList()));
        this.setPublisher(naverBook.getPublisher());
        this.setPrice(naverBook.getPrice());
        this.setSalePrice(naverBook.getSalePrice());
        this.setThumbnail(naverBook.getThumbnail());
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContents() {
        return contents;
    }

    public Book setContents(String contents) {
        this.contents = contents;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public Book setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public String getDateTime() {
        return dateTime;
    }

    public Book setDateTime(String dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public Book setAuthors(List<String> authors) {
        this.authors = authors;
        return this;
    }

    public String getPublisher() {
        return publisher;
    }

    public Book setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public Integer getPrice() {
        return price;
    }

    public Book setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public Integer getSalePrice() {
        return salePrice;
    }

    public Book setSalePrice(Integer salePrice) {
        this.salePrice = salePrice;
        return this;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public Book setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }
}
