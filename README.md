# Barbershop
Third assigment of PRG2.

Requeriments:
Una barbería dispone de varios barberos y de varias sillas de espera para los clientes. Si no hay clientes los barberos se ponen a dormir. Si llega un cliente y no hay nadie esperando despierta a un barbero y éste le corta el pelo. Si en cambio todos los barberos están ocupados el cliente espera en una silla si hay alguna libre, sino se va. Los barberos a medida que terminan su trabajo sobre un cliente eligen al siguiente cliente que más tiempo lleva esperando.

Se pide un programa en java que simule el funcionamiento de la barbería. Los barberos se identificarán por letras mayúsculas, A, B, C, ...  del alfabeto inglés, siendo 1 <= n<=26 el número de barberos. Los clientes se identificarán por números 1, 2, 3, ... siendo 1 <= m <= 100 el número de clientes. El programa se ejecutará durante t segundos cumpliendo que nunca un barbero puede estar atendiendo a más de un cliente y que la barbería tiene un número limitado de sillas de espera y cada una sólo puede usarse por un cliente. El alumno deberá implementar y entregar las clases Cliente, Barbero y Barberia, dejando la clase Main tal como está. Se podrán usar más clases si se considera necesario. La clase Main no debe subirse en la entrega.

No se podrá usar el paquete java.util.concurrent ni ninguno de sus subpaquetes. Se anularán las prácticas que los usen. 

El programa deberá lanzar los siguientes mensajes por la salida estándar, donde i representa el identificador de un barbero y j el identificador de un cliente:

- El barbero i se ha creado.
- El barbero i se pone a dormir.
- El barbero i atiende al cliente j.
- El barbero i ha cortado el pelo al cliente j.
- El barbero i ha sido destruido.
- El cliente j se ha creado.
- El cliente j llega a la barbería.
- El cliente j se marcha sin ser atendido.
- El cliente j se sienta en una silla de espera.
- El cliente j ha sido destruido.

Cada cliente va a la  barbería cada cierto tiempo y ese tiempo sigue una distribución normal de media μ y desviación típica σ. Cada barbero tarda en cortar el pelo a un cliente un tiempo que sigue una distribución exponencial de parámetro λ. Para calcular esos tiempos se generarán números que siguen esas distribuciones y para ello se usará el paquete org.apache.commons.math3.distribution incluido en la librería Apache Commons Math que puede descargarse de http://commons.apache.org/proper/commons-math/download_math.cgi.

Entrada

La entrada vendrá dada de la siguiente forma:

1ª línea: el número de barberos n y el número de clientes m.
2ª línea: el tiempo en segundos t de simulación.
3ª línea: los parámetros media μ y desviación típica σ  (en milisegundos) de la distribución normal que modeliza el tiempo de espera de los clientes para ir a la barbería.
4ª línea: el parámetro λ (en milisegundos) de la distribución exponencial que modelista el tiempo que tarda un barbero en cortar el pelo.
5ª línea: el número de sillas disponibles en la barbería.
Salida

Los mensajes indicados más arriba, cada uno en una línea completa.
