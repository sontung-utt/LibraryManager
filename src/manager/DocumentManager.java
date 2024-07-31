package manager;

import model.Book;
import model.Document;
import model.Magazine;
import model.News;

import java.util.ArrayList;

public class DocumentManager implements IManager<Document> {
    ArrayList<Document> documents;

    public DocumentManager() {
        this.documents = new ArrayList<>();
    }

    @Override
    public void add(Document document) {
        documents.add(document);
    }

    @Override
    public void remove(int id) {
        int index = findIndexById(id);
        documents.remove(index);
    }

    @Override
    public void update(Document document, int id) {
        int index = findIndexById(id);
        documents.set(index, document);
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < documents.size(); i++) {
            if (documents.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ArrayList<Document> getAll() {
        return documents;
    }

    public Document findDocumentById(int id) {
        for (Document document : documents) {
            if (document.getId() == id) {
                return document;
            }
        }
        return null;
    }

    public ArrayList<Book> getBook() {
        ArrayList<Book> books = new ArrayList<>();
        for (Document document : documents) {
            if (document instanceof Book) {
                books.add((Book) document);
            }
        }
        return books;
    }

    public ArrayList<Magazine> getMagazine() {
        ArrayList<Magazine> magazines = new ArrayList<>();
        for (Document document : documents) {
            if (document instanceof Magazine) {
                magazines.add((Magazine) document);
            }
        }
        return magazines;
    }

    public ArrayList<News> getNews() {
        ArrayList<News> news = new ArrayList<>();
        for (Document document : documents) {
            if (document instanceof News) {
                news.add((News) document);
            }
        }
        return news;
    }

}
