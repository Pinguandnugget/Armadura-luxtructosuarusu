# Luxtructosaurus — Fabric 1.21.1 (proyecto fuente corregido)

**Estado:** código fuente de prueba, **NO es un .jar compilado**. No se ha podido verificar su compilación ni el renderizado real en Minecraft. Debe probarse primero en un servidor y cliente de prueba antes de instalarlo en Arclight/HolyHosting.

## Estadísticas confirmadas

| Pieza | Diamante | Luxtructosaurus | Durabilidad Luxtructosaurus |
|---|---:|---:|---:|
| Casco | 3 | 4 | 407 |
| Peto | 8 | 9 | 592 |
| Pantalones | 6 | 7 | 555 |
| Botas | 3 | 4 | 481 |
| Total | 20 | 24 | — |

- Durabilidad: **igual a la netherita vanilla** (multiplicador 37).
- Tenacidad: **2 por pieza** (diamante).
- Resistencia al retroceso: **0** (diamante).
- Encantabilidad: **10** (diamante).
- Sonido al equipar y reparación: diamante.
- **Resistencia al fuego**: aplicada solo si se equipan las cuatro piezas a la vez; se renueva cada 5 ticks con duración de 12 ticks. Después de quitar alguna pieza, el efecto residual puede durar como máximo alrededor de 0,6 s si no existía otra fuente de resistencia al fuego. No se elimina la resistencia al fuego procedente de pociones u otros mods.
- No añade estadísticas especiales adicionales.

## Herrería

Plantilla Luxtructosaurus + armadura de diamante correspondiente + lingote de netherita -> armadura Luxtructosaurus. Las cuatro recetas originales de mejora a netherita son sustituidas por recetas homónimas para evitar fabricar armadura de netherita mediante esas mejoras. Las herramientas de netherita no cambian. Los objetos de netherita existentes no se borran. Plantilla duplicable con 1 plantilla + 8 diamantes; por ahora la plantilla inicial se obtiene mediante /give (no hay loot de obtención natural establecido).

## Modelos y texturas

- Usa iconos extraídos de los archivos Blockbench proporcionados, y un primer atlas animado de lava derivado de las referencias.
- Los `.bbmodel` proporcionados son iconos/plantillas, **no incluyen modelos 3D de armadura wearable**; los cachos 3D del casco **NO están implementados**.
- La animación visual y las coordenadas UV de las texturas del equipamiento requieren comprobación dentro del juego; no prometemos brillo emisivo de shader ni iluminación real. El concepto artístico no es un modelo 3D ejecutable.

## Compilación

Con JDK 21 y Gradle 8.10.x, desde esta carpeta ejecutar `gradle build`. Los componentes descargables de Fabric requieren conexión a Maven. Instalar el `jar` de producción (no el `-sources.jar`) en **mods/** de clientes y servidor Fabric 1.21.1. Si usas Arclight híbrido Fabric, haz antes una copia completa del servidor; la compatibilidad no está comprobada.

## Comandos

`/give @s luxtructosaurus:plantilla_luxtructosaurus`
`/give @s luxtructosaurus:casco_luxtructosaurus`
`/give @s luxtructosaurus:peto_luxtructosaurus`
`/give @s luxtructosaurus:pantalones_luxtructosaurus`
`/give @s luxtructosaurus:botas_luxtructosaurus`

**Nota sobre el equilibrio:** 24 puntos de defensa superan los 20 puntos de la netherita, aunque la Luxtructosaurus tiene menor tenacidad y resistencia al retroceso. Minecraft suele limitar el cálculo efectivo de armadura a 20 puntos. No es posible garantizar que sea globalmente "inferior a netherita" contra todo tipo de daño con estas cifras.
