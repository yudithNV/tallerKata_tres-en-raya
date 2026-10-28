import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TresEnRayaTest {
    private TresEnRaya juego;

    @BeforeEach
    void iniciar() { juego = new TresEnRaya(); }

    // requerimiento 1 
    @Test 
    void fueraDelEjeX_lanzaExcepcion() {
        assertThrows(RuntimeException.class, () -> juego.jugar(5, 2));
    }
    @Test 
    void fueraDelEjeY_lanzaExcepcion() {
    assertThrows(RuntimeException.class, () -> juego.jugar(2, 5));
    }
    @Test 
    void lugarOcupado_lanzaExcepcion() {
        juego.jugar(1, 1);
        assertThrows(RuntimeException.class, () -> juego.jugar(1, 1));
    }
}