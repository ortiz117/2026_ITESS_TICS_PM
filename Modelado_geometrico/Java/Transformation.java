/*
 * ================================================================
 *  2026 - ITESS - TICS
 *  ENERO - JUNIO
 *  ASIGNATURA: PLANIFICACIÓN DE MOVIMIENTOS
 *  UNIDAD 1.3: TRANSFORMACIONES RÍGIDAS
 *
 *  DOCENTE: Francisco Javier Montecillo Puente
 *  DESARROLLADOR: Isaac Ortiz Arias
 *  FECHA: 20 / 02 / 2026
 * ================================================================
 *
 *  METODOLOGÍA DE DESARROLLO
 *  ---------------------------------------------------------------
 *  MODELO WATERFALL (CASCADA)
 *
 *  El desarrollo del sistema se realizó utilizando el modelo
 *  secuencial Waterfall, el cual establece fases definidas que
 *  deben completarse antes de avanzar a la siguiente etapa.
 *
 *  FASES DEL PROYECTO:
 *
 *  1) ANÁLISIS DE REQUERIMIENTOS
 *     ------------------------------------------------------------
 *     - Implementar transformaciones rígidas en el plano cartesiano.
 *     - Permitir operaciones de:
 *          • Traslación
 *          • Rotación
 *          • Composición (Trasladar + Rotar)
 *     - Soporte para tipos de datos float y double.
 *
 *
 *  2) DISEÑO DEL SISTEMA
 *     ------------------------------------------------------------
 *     DISEÑO UML (CLASE PRINCIPAL)
 *
 *     ------------------------------------------------------------
 *     |                    Transformaciones                      |
 *     ------------------------------------------------------------
 *     | + static float[]  move(float[] xt, float[] xd)           |
 *     | + static double[] move(double[] xt, double[] xd)         |
 *     | + static float[]  rotate(float[] xt, float angle)        |
 *     | + static double[] rotate(double[] xt, double angle)      |
 *     | + static float[]  rotatemove(float[] xt, float[] xd,     |
 *     |                              float angle)                 |
 *     | + static double[] rotatemove(double[] xt, double[] xd,   |
 *     |                              double angle)                |
 *     ------------------------------------------------------------
 *
 *     DESCRIPCIÓN:
 *     - move():       Realiza una traslación sumando el desplazamiento.
 *     - rotate():     Aplica transformación de rotación usando
 *                     funciones trigonométricas.
 *     - rotatemove(): Composición: primero traslada, luego rota.
 *
 *     DISEÑO DE ALGORITMO:
 *     - Entrada de coordenadas.
 *     - Selección de operación.
 *     - Aplicación de fórmula matemática.
 *     - Retorno del nuevo valor transformado.
 *
 *
 *  3) IMPLEMENTACIÓN
 *     ------------------------------------------------------------
 *     - Codificación de métodos estáticos.
 *     - Uso de funciones matemáticas (Math.sin, Math.cos).
 *     - Validación de tipos de datos.
 *
 *
 *  4) PRUEBAS
 *     ------------------------------------------------------------
 *     - Pruebas unitarias con valores positivos y negativos.
 *     - Validación de resultados esperados.
 *     - Comparación con resultados matemáticos teóricos.
 *     - Ver: TransformationTest.java
 *
 * ================================================================
 */

public class Transformation {

    // ============================================================
    //  TRASLACIÓN - float
    //  x' = x + dx
    //  y' = y + dy
    // ============================================================
    public static float[] move(float[] xt, float[] xd) {
        return new float[] {
            xt[0] + xd[0],
            xt[1] + xd[1]
        };
    }

    // ============================================================
    //  TRASLACIÓN - double
    // ============================================================
    public static double[] move(double[] xt, double[] xd) {
        return new double[] {
            xt[0] + xd[0],
            xt[1] + xd[1]
        };
    }

    // ============================================================
    //  ROTACIÓN - float
    //  x' = x*cos(θ) - y*sin(θ)
    //  y' = x*sin(θ) + y*cos(θ)
    //  El ángulo se recibe en grados
    // ============================================================
    public static float[] rotate(float[] xt, float angle) {
        float rad = (float) Math.toRadians(angle);
        float cos = (float) Math.cos(rad);
        float sin = (float) Math.sin(rad);
        return new float[] {
            xt[0] * cos - xt[1] * sin,
            xt[0] * sin + xt[1] * cos
        };
    }

    // ============================================================
    //  ROTACIÓN - double
    // ============================================================
    public static double[] rotate(double[] xt, double angle) {
        double rad = Math.toRadians(angle);
        return new double[] {
            xt[0] * Math.cos(rad) - xt[1] * Math.sin(rad),
            xt[0] * Math.sin(rad) + xt[1] * Math.cos(rad)
        };
    }

    // ============================================================
    //  COMPOSICIÓN - float
    //  Primero traslada, luego rota el resultado
    // ============================================================
    public static float[] rotateMove(float[] xt, float[] xd, float angle) {
        return rotate(move(xt, xd), angle);
    }

    // ============================================================
    //  COMPOSICIÓN - double
    // ============================================================
    public static double[] rotateMove(double[] xt, double[] xd, double angle) {
        return rotate(move(xt, xd), angle);
    }
}