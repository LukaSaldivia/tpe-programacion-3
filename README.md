# Algoritmos de Selección de Máquinas (Greedy y Backtracking)

Este proyecto implementa dos algoritmos (Greedy y Backtracking) para seleccionar máquinas de producción con el objetivo de alcanzar exactamente una cantidad dada de piezas, utilizando la menor cantidad de máquinas posibles.

## Estructura del proyecto

```
📁 TPE
    📁 input
    📁 processed
    📁 src
        📄 App.java
        📁 Algoritmos
            📄 Backtracking.java
            📄 Greedy.java
        📁 FileManager
            📄 FileManager.java
        📁 Maquina
            📄 Maquina.java
        📁 misc
            📄 Module.java
    📄 Enunciado_TPE.pdf
```

## Instrucciones de uso

> Requisitos: tener instalado **Java JDK** (Java 8 o superior) y configurado correctamente el entorno para compilar desde terminal.

### 1. Colocar el archivo de entrada

Ubique un archivo `.txt` dentro de la carpeta `input/`. El archivo debe seguir el formato esperado por el programa (ver sección [Formato del archivo de entrada `(.txt)`](#formato-del-archivo-de-entrada-txt)).

> Solo se procesará **un archivo por ejecución**. Si hay múltiples archivos en `input/`, se tomará uno arbitrariamente.

### 2. Compilar el proyecto

Desde la raíz del repositorio, ejecute el comando en su editor de código.

### 3. Resultados y post-procesamiento
Los resultados de la ejecución se mostrarán en consola:

- Secuencia de máquinas utilizadas.
- Cantidad de piezas producidas.
- Cantidad de máquinas puestas en funcionamiento.
- Métrica adicional: cantidad de estados o candidatos generados.

El archivo de entrada utilizado será automáticamente movido a la carpeta `processed/` para evitar que sea reusado en ejecuciones posteriores.

## Formato del archivo de entrada `(.txt)`
El archivo debe contener los datos necesarios para construir las máquinas y definir el objetivo. El formato esperado es:
```
<piezas-totales>
<nombre-maquina-1>,<piezas-que-produce>
<nombre-maquina-2>,<piezas-que-produce>
<nombre-maquina-3>,<piezas-que-produce>
...
```
*Ejemplo:*
```
25
M1,6
M2,5
M3,4
```

