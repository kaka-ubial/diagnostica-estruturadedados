import java.util.concurrent.atomic.AtomicInteger;

public class Cliente {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String nome;

    public Cliente(String nome){
        this.id = count.incrementAndGet();
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome=nome;
    }
}
