# Proyecto Spring Boot

Este proyecto de Spring Boot implementa una aplicación utilizando la arquitectura hexagonal, también conocida como puertos y adaptadores. La arquitectura hexagonal se centra en separar la lógica de negocio del mecanismo de entrada y salida, lo que facilita la prueba, la escalabilidad y el mantenimiento del código.
					
## Principios SOLID y patrones de diseño empleados

1. **Principio de Responsabilidad Única (SRP)**: Cada clase tiene una única responsabilidad.
   - Ejemplo: `PriceService` se encarga de gestionar los precios.
   
2. **Principio de Abierto/Cerrado (OCP)**: Las entidades deben estar abiertas para su extensión pero cerradas para su modificación.
   - Ejemplo: La interfaz `PriceRepository` permite extender funcionalidades de acceso a datos sin modificar el servicio principal.

3. **Principio de Sustitución de Liskov (LSP)**: Los objetos de un programa deben ser reemplazables por instancias de sus subtipos sin alterar la corrección del programa.
   - Ejemplo: Las implementaciones de `PriceRepository` pueden sustituirse sin afectar el comportamiento del servicio.

4. **Principio de Segregación de la Interfaz (ISP)**: Los clientes no deben ser obligados a depender de interfaces que no usan.
   - Ejemplo: `PriceRepository` define métodos específicos para la persistencia de precios, evitando la dependencia de métodos no utilizados en el servicio.

5. **Principio de Inversión de Dependencias (DIP)**: Los módulos de alto nivel no deben depender de los módulos de bajo nivel. Ambos deben depender de abstracciones.
   - Ejemplo: `PriceService` depende de la abstracción `PriceRepository`, no de su implementación concreta, permitiendo la flexibilidad en el cambio de implementaciones.


# Pruebas de la clase PriceController

En este archivo se encuentran las pruebas unitarias para la clase `PriceController`. Estas pruebas se realizan utilizando JUnit y Mockito para simular el comportamiento del servicio `PriceService`.

## Configuración inicial

Antes de ejecutar las pruebas, se establece la configuración inicial en el método `setUp()`, donde se definen diferentes objetos `LocalDateTime` para simular fechas y horas específicas.

## Casos de prueba

### Test: testGetPrice_14_10()

- **Descripción**: Verifica si se puede obtener el precio para la fecha y hora "2024-02-14 10:00:00".
- **Resultado esperado**: Se espera un código de estado HTTP 200 (OK) si se encuentra el precio.

### Test: testGetPrice_14_16()

- **Descripción**: Verifica si se puede obtener el precio para la fecha y hora "2024-02-14 16:00:00".
- **Resultado esperado**: Se espera un código de estado HTTP 200 (OK) si se encuentra el precio.

### Test: testGetPrice_14_21()

- **Descripción**: Verifica si se puede obtener el precio para la fecha y hora "2024-02-14 21:00:00".
- **Resultado esperado**: Se espera un código de estado HTTP 200 (OK) si se encuentra el precio.

### Test: testGetPrice_15_10()

- **Descripción**: Verifica si se puede obtener el precio para la fecha y hora "2024-02-15 10:00:00".
- **Resultado esperado**: Se espera un código de estado HTTP 404 (NOT FOUND) si no se encuentra el precio.

### Test: testGetPrice_16_21()

- **Descripción**: Verifica si se puede obtener el precio para la fecha y hora "2024-02-16 21:00:00".
- **Resultado esperado**: Se espera un código de estado HTTP 404 (NOT FOUND) si no se encuentra el precio.
