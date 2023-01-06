# Proyecto Aeropuerto

### Este ejercicio corresponde al tema de programación orientada a objetos del curso de Java de Programación ATS
***

Diseñar y codificar una aplicación informática para una compañía de gestión aeroportuaria satisfaciendo los siguientes requisitos:

Para cada aeropuerto es necesario saber:
- Todas las compañías de vuelos que operan en él
- Nombre del aeropuerto, la ciudad, donde se ubica y el país al que pertenece.

Cada compañía se caracteriza por el nombre y la lista de vuelos que ofrece.

Los vuelos están definidos por su identificador, la ciudad de origen, la ciudad de destino, el precio del viaje, la lista de pasajeros, el número máximo de pasajeros permitidos en el vuelo y el número real de pasajeros que han reservado asiento en el avión.

Los aeropuertos pueden ser privados o públicos:
- Los aeropuertos privados tienen una serie de empresas que los patrocinan y es necesario saber el nombre de cada una de las empresas.
- Para los aeropuertos públicos se requiere saber la cantidad de dinero correspondiente a la subvención gubernamental.

Se necesita gestionar también la información de los pasajeros:
- Para cada pasajero se necesita saber nombre, número de pasaporte y nacionalidad.

La aplicación tendrá un menú con las siguientes opciones: 
1. Consultar los aeropuertos gestionados, indicando separadamente los aeropuertos públicos y los privados. Para cada uno de ellos deberá mostrar su nombre, ciudad de ubicación y país al que pertenece.
2. Visualizar las empresas que patrocinan un determinado aeropuerto en casi de que sea privado, o la cuantía de la subvención en caso de que se trate de un aeropuerto público.
3. Para un determinado aeropuerto, se debe poder mostrar la lista de compañías que vuelan desde ese aeropuerto.
4. Para una determinada compañía que operan en un aeropuerto concreto, listar todos los posibles vuelos que dicha compañía ofrece, mostrando su identificador, ciudad de origen y destino y el precio del vuelo.
5. Mostrar todos los posibles vuelos (identificador) que pertenecen a una ciudad origen a otra ciudad destino (indicada por el usuario) y mostrar su precio.


### Diagrama UML del proyecto
![Diagrama UML](https://github.com/miguel-mahay/Java-Ejercicios/blob/main/ProyectoAeropuerto/UML_ProyectoAeropuerto.PNG)
