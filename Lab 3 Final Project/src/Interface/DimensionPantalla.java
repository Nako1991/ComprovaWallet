package Interface;

import java.awt.*;

public interface DimensionPantalla {
    default Dimension calcularDimensionPantalla(){
        Dimension tamañoPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        return tamañoPantalla;
    }
}
