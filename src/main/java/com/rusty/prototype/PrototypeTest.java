package com.rusty.prototype;

import java.util.ArrayList;
import java.util.Objects;

class Book{

    private String author;
    private String title;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}

//이 클래스를 복제가능한 클래스로 선언(Cloneable)
//인터페이스이지만 구현부는 없다 -> mark interface
class BookShelf implements Cloneable {

    private ArrayList<Book> shelf;

    public BookShelf() {
        shelf = new ArrayList<Book>();

    }

    public ArrayList<Book> getShelf() {
        return shelf;
    }

    public void setShelf(ArrayList<Book> shelf) {
        this.shelf = shelf;
    }

    public void addBook(Book book) {
        shelf.add(book); // insert book
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        //return super.clone();   //object 형식으로 return, clone implements가 필요 (shallow copy - stack 영역의 메모리 주소)

        //deep copy시 재정의 필요
        BookShelf anotherBookShelf = new BookShelf();

        //기존의 book의 데이터를 새 책장으로 가져옴 (deep copy - heap 영역의 데이터 자체)
        for (Book book : shelf ){
            book = new Book(book.getAuthor(), book.getTitle());
            anotherBookShelf.addBook(book);
        }

        return anotherBookShelf;

    }

    @Override
    public String toString() {
        return shelf.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(shelf);
    }
}

public class PrototypeTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        
        BookShelf bookShelf = new BookShelf();
        bookShelf.addBook(new Book("kim","태백산맥1"));
        bookShelf.addBook(new Book("lee","빨치산"));
        bookShelf.addBook(new Book("park","경기도"));

        System.out.println("bookShelf = " + bookShelf);     //origin

        BookShelf anotherBookShlef = (BookShelf) bookShelf.clone(); //object return을 다운캐스팅

        System.out.println("anotherBookShlef = " + anotherBookShlef);

        System.out.println(bookShelf == anotherBookShlef);

        bookShelf.getShelf().get(0).setAuthor("Mango");
        bookShelf.getShelf().get(0).setTitle("Jane");

        //shallow copy 방식으로 clone 되었으므로 객체 값이 변경되지 않음
        System.out.println(bookShelf);
        System.out.println(anotherBookShlef);

        System.out.println(bookShelf.hashCode());
        System.out.println(anotherBookShlef.hashCode());


    }
}
