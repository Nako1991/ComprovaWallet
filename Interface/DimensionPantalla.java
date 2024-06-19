package Interface;

import java.awt.*;

public interface DimensionPantalla {

    default Dimension calcularDimensionPantalla(){
        Dimension dimensionPantalla = Toolkit.getDefaultToolkit().getScreenSize();
        return dimensionPantalla;
    }

}
