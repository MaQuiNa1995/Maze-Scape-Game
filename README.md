# Maze Scape Game

Este proyecto es la implementacion de un laberinto sencillo a traves de la api de graficos javaSwing de java

Los mapas se componen de:
- `#` para las paredes
- `E` para la entrada
- `S` para la salida
- `J` para controlar la posicion del jugador internamente

# Controles:
- W mover Arriba
- A mover Izquierda
- S mover Abajo
- D mover Derecha

## Actualmente hay 2 mapas pre-definidos y la posiblidad de hacer uno customizado

Solo tienes que cambiar esta parte del codigo:

```
this.nivel = laberintoService.createMapLv1();
```
<a href="https://github.com/MaQuiNa1995/Maze-Scape-Game/blob/master/src/main/java/maquina1995/maze/scape/Main.java#L26">Ir a la línea 26 del archivo Main.java en GitHub</a>

Por las siguientes opciones:
- `createMapLv2()`
- `generateFromFile()`

## Ejemplo de mapa:

```
#####
#E  #
### #
#S  #
#####
```

Para crear el mapa tenemos que editar el archivo `customMap.map`

No hace falta que metas al jugador `J`

## Gif Con funcionamiento:

![hippo](https://github.com/MaQuiNa1995/Maze-Scape-Game/blob/master/doc/ejecucion.gif?raw=true)