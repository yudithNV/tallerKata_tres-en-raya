import static org.junit.jupiter.api.Assertions.assertEquals;
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
    // requerimiento 2
    @Test 
    void primerTurnoEsDeX() {
    assertEquals('X', juego.proximoJugador());
    }
    @Test 
    void despuesDeXJuegaMas() {
        juego.jugar(1, 1);
        assertEquals('+', juego.proximoJugador());
    }
    @Test 
    void despuesDeMasJuegaX() {
        juego.jugar(1, 1);
        juego.jugar(2, 1);
        assertEquals('X', juego.proximoJugador());
    }
    //requerimiento 3
    @Test 
    void sinCondicionDeVictoria_noHayGanador() {
        assertEquals("No hay ganador", juego.jugar(1, 1));
    }

    //requerimiento 3
    @Test 
    void ganaPorLineaHorizontal() {
        juego.jugar(1, 1); juego.jugar(1, 2);
        juego.jugar(2, 1); juego.jugar(2, 2);
        assertEquals("X gana", juego.jugar(3, 1));
    }
    @Test 
    void ganaPorLineaVertical() {
        juego.jugar(1, 1); juego.jugar(2, 1);
        juego.jugar(1, 2); juego.jugar(2, 2);
        assertEquals("X gana", juego.jugar(1, 3));
    }
    @Test
    void ganaPorLineaDiagonal() {
        juego.jugar(1, 1); juego.jugar(1, 2);
        juego.jugar(2, 2); juego.jugar(1, 3);
        assertEquals("X gana", juego.jugar(3, 3));
    }
}