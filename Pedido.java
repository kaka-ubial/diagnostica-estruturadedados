import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Pedido {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private List<Item> itens;
    private float taxa;

    public Pedido(List<Item> itens){
        this.id = count.incrementAndGet();
        this.itens = itens;
        this.taxa = 0.1f;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public float getTaxa() {
        return taxa;
    }

    public float calcularPreco() {
        float valorTotal = 0;
        for (Item item : itens) {
            float valorItem = item.getPreco();
            valorTotal += valorItem;
        }
        return new BigDecimal(valorTotal + (valorTotal * this.taxa))
                .setScale(2, RoundingMode.FLOOR)
                .floatValue();
    }
}
