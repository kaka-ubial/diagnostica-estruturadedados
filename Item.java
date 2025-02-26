import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class Item {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String nome;
    private float preco;

    public Item(String nome, float preco){
        this.id = count.incrementAndGet();
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public float getPreco(){
        return preco;
    }

    public void setPreco(float preco){
        this.preco = preco;
    }
}
