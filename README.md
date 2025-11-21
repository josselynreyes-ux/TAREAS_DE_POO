Ejemplos de salida del codigo Juegos

<img width="405" height="796" alt="image" src="https://github.com/user-attachments/assets/99ef7b29-4ddf-4ff9-9f4f-06db73d17fd4" />

<img width="341" height="653" alt="image" src="https://github.com/user-attachments/assets/c00dca25-64e1-4cb9-8838-19034f4d0928" />

<img width="447" height="357" alt="image" src="https://github.com/user-attachments/assets/50f86571-7a83-4ef4-8e12-575a07e8ebfa" />

<img width="330" height="419" alt="image" src="https://github.com/user-attachments/assets/91630df6-d0c8-4870-82e6-92a416b32736" />

<img width="354" height="256" alt="image" src="https://github.com/user-attachments/assets/2277db5e-2c36-4402-b21b-5abb2cae3671" />

Se crea una clase base llamada Juego, que contiene lo común de todos los videojuegos, como el nombre y el género.
A partir de esa base salen dos tipos de juegos: MarioBros y CarreraVehiculos. Cada uno tiene datos propios, como "vidas" o "vehículos".
Cuando el usuario registra un juego, el programa revisa que el nombre no esté vacío, que el género no sea una cadena inútil y que los valores numéricos sean positivos. Si algo está mal, el sistema lanza un mensaje de error y no permite guardar el juego.
Los juegos se guardan en una lista. Luego el programa permite mostrarlos, buscarlos por nombre o mostrarlos por tipo. Cuando se muestran, cada clase enseña sus datos de una manera diferente.

UML

<img width="999" height="613" alt="image" src="https://github.com/user-attachments/assets/4689ccd4-e157-4471-8866-bb532ffc840d" />


Ejemplos de salida del codigo Dispositivo

<img width="332" height="644" alt="image" src="https://github.com/user-attachments/assets/259b48ba-279d-4224-9f44-0d24fa324925" />

<img width="364" height="697" alt="image" src="https://github.com/user-attachments/assets/bae0c4d4-28e3-4a02-a4b0-c23214dc8019" />

<img width="365" height="240" alt="image" src="https://github.com/user-attachments/assets/d7e7d730-1276-4e54-b494-c3b698a89ada" />

Primero se crea una clase base llamada Dispositivo, que contiene datos que todos los aparatos tienen, como la marca, el modelo y el precio. Estos datos están protegidos para que no puedan modificarse de forma incorrecta.
Las clases Laptop y Telefono usan esa base y solo agregan datos especiales según el tipo de aparato.
Cada vez que tratamos de crear un dispositivo, el programa revisa cosas como que la marca no esté vacía o que el precio no sea negativo. Si algo está mal, se envía un mensaje avisando del error. Esto se hace para que el sistema no guarde información equivocada.
Todos los dispositivos que se crean se van guardando dentro de una lista. Más tarde, se pueden mostrar todos juntos, aunque sean de tipos diferentes, y cada uno muestra su información según el tipo de clase que sea.
