import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TransformationTest {

    public static void main(String[] args) {
        //Caso 1: probar move
        //origen (0,0) trasladar (1,1) 
        //Resultado (1,1)

        float xt [] = {0, 0};
        float xd [] = {1, 1};
        float xt1 [] = Transformation.move(xt, xd);

        System.out.println("move case: ("+xt1[0] + ", " + xt1[1] + ")");

        //caso 2: probar rotate
        // origen (2, 1) rotar 45 grados
        xt[0] = 2;
        xt[1] = 1;
        float angle = (float) (45 * Math.PI / 180);
        float xt2 [] = Transformation.rotate(xt, angle);
        System.out.println("rotate case: " + java.util.Arrays.toString(xt2));

        // case 3: probar rotateMove
        //origen (2,1) rotar 45 move (1,1)
        xt[0] = 2;
        xt[1] = 1;

        xd[0] = 1;
        xd[1] = 1;

        angle = (float) (45 * Math.PI / 180);
        float xt3[] = Transformation.rotateMove(xt, xd, angle);
        System.out.println("rotateMove case: " + java.util.Arrays.toString(xt3));
    }
}