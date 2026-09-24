# Práctica: ArrayList vs. LinkedList

**Nombre:** Danna Ibarra


## 1. Objetivo

Comparar experimentalmente `ArrayList` y `LinkedList` en acceso, inserción,
eliminación y recorrido, y justificar cuándo usar cada una.

## 2. Tiempos obtenidos

### 2.1 Acceso con `get(i)` (N = 100,000)

| Ejecución | ArrayList (ms) | LinkedList (ms) |
|-----------|----------------|-----------------|
| 1         | 11.478         | 5516.276        |
| 2         | 11.624         | 5459.874        |
| 3         | 10.875         | 5406.634        |
| Promedio  | 11.325         | 5460.928        |

### 2.2 Acceso con `for-each` (N = 100,000)

| Ejecución | ArrayList (ms) | LinkedList (ms) |
|-----------|----------------|-----------------|
| 1         | 12.211         | 4.575           |
| 2         | 10.646         | 3.887           |
| 3         | 11.288         | 4.867           |
| Promedio  | 11.381         | 4.443           |

### 2.3 Comparación `get(i)` vs `for-each`

___ (3-4 líneas: cuál fue más rápido en cada lista, cuántas veces más
lento fue `get(i)` en LinkedList, y por qué.)

## 3. Inserciones y eliminaciones

**Hipótesis (escrita antes de ejecutar):** ___

| Operación             | ArrayList (ms) | LinkedList (ms) |
|-----------------------|----------------|-----------------|
| Insertar al inicio (50,000) | 169.870        | 5.387           |
| Insertar al final (100,000) | 7.824          | 3.718           |
| Eliminar al inicio (100,000)| 657.774        | 8.903           |

**Análisis:** ___ (¿se cumplió tu hipótesis? ¿por qué?)

## 4. Tabla comparativa final

| Característica | `ArrayList` | `LinkedList` |
|---|---|---|
| Implementa `List` | Sí | Sí |
| Estructura | Arreglo dinámico | Lista doblemente enlazada |
| Acceso `get(i)` | O(1) | O(n) |
| Modificación `set(i)` | O(1) | O(n) |
| Inserción al final | O(1) amortizado | O(1) |
| Inserción al inicio | O(n) | O(1) |
| Eliminación al inicio | O(n) | O(1) |
| Búsqueda por valor | O(n) | O(n) |
| Recorrido completo | O(n) | O(n) |
| Implementa `Deque` | No | Sí |
| Memoria adicional por elemento | Menor en general | Mayor por los enlaces |
| Acceso aleatorio frecuente | Adecuado | Poco adecuado |
| Operaciones frecuentes en extremos | No es su principal fortaleza | Adecuado |

## 5. Sistema de cola de trabajos

Se implementó en tres versiones:

1. `List` con `ArrayList`
2. `List` con `LinkedList` (solo cambió la línea de creación)
3. `Deque` con `LinkedList` (`addFirst`, `addLast`, `peekFirst`, `pollFirst`)

___ (Explica en 3-4 líneas qué diferencias encontraste y por qué `Deque`
es mejor diseño para este problema.)

## 6. Respuestas a las preguntas de análisis

1. Ambas implementan la interfaz List (que a su vez extiende Collection e Iterable)
2. ArrayList usa un arreglo dinámico y LinkedList usa una lista doblemente enlazada
3. Porque los elementos están contiguos en memoria, así que la posición del elemento i se calcula directamente a partir del índice
4. Porque los nodos no están contiguos y no existe acceso directo por posición
5. Primero se verifica si el arreglo interno tiene capacidad; si está lleno, se crea uno más grande y se copian los elementos
6. Porque los elementos no dependen de una posición física en memoria
7. Porque solo es cierto para inserciones en los extremos (inicio o final) o cuando ya se tiene un iterador posicionado en el punto de inserción
11. No coinciden exactamente, pero sí siguen la tendencia. Big-O describe cómo crece el costo al aumentar n, no el tiempo real en milisegundos, pues ignora factores constantes
12. Cada elemento requiere un objeto nodo aparte, que además del dato guarda dos referencias (anterior y siguiente) y la cabecera propia de todo objeto en Java
13. Permite cambiar la implementación (ArrayList, LinkedList, etc.) modificando solo la línea donde se crea el objeto, sin tocar el resto del código
14. Porque el problema solo necesita operar en los extremos: agregar al inicio (urgentes) y al final (normales), consultar el primero y eliminar el primero
15. Cuando se necesita acceso frecuente por índice (get/set), recorridos frecuentes, o cuando las inserciones son principalmente al final
16. Cuando hay muchas inserciones y eliminaciones en los extremos, como colas, pilas o deques (por ejemplo, la cola de trabajos), o cuando se inserta o elimina durante un recorrido usando un Iterator/ListIterator

