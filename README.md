Reproductor de Música (versión Fragments)
Este proyecto es una aplicación Android que implementa un reproductor de música simple utilizando Fragments. La aplicación permite al usuario seleccionar una pista de audio de una lista y reproducirla.
Características

Selección de pistas de audio mediante un Spinner
Controles de reproducción (Play y Stop)
Interfaz dividida en dos fragments: selección de audio y controles de reproducción
Manejo de estado de reproducción

Estructura del Proyecto
El proyecto consta de los siguientes componentes principales:
Actividades

MainActivity: Actividad principal que actúa como contenedor para los fragments y coordina la interacción entre ellos.

Fragments

AudioSelectionFragment: Permite al usuario seleccionar una pista de audio de una lista.
PlayerControlFragment: Contiene los controles de reproducción y maneja la lógica de reproducción de audio.

Layouts

activity_main.xml: Layout principal que contiene el contenedor de fragments.
fragment_audio_selection.xml: Layout para la selección de pistas de audio.
fragment_player_control.xml: Layout para los controles de reproducción.

Funcionamiento

Al iniciar la aplicación, se muestran tanto el AudioSelectionFragment como el PlayerControlFragment.
El usuario selecciona una pista de audio del Spinner en AudioSelectionFragment.
La selección se comunica a PlayerControlFragment a través de MainActivity.
El usuario puede reproducir o detener la pista seleccionada usando los botones en PlayerControlFragment.

Manejo de la Reproducción de Audio

La reproducción de audio se maneja en PlayerControlFragment utilizando la clase MediaPlayer de Android.
La aplicación libera los recursos del MediaPlayer adecuadamente cuando se detiene la reproducción o se destruye el fragment.

Requisitos

Android SDK
Dispositivo o emulador con Android (versión mínima por determinar)

Instalación y Ejecución

Clone el repositorio.
Abra el proyecto en Android Studio.
Asegúrese de que los archivos de audio (audio1, audio2, etc.) estén presentes en la carpeta res/raw.
Ejecute la aplicación en un emulador o dispositivo Android.

Notas Importantes

Los archivos de audio deben estar en formato compatible con Android (por ejemplo, MP3) y colocados en la carpeta res/raw del proyecto.
La aplicación utiliza la API de Fragment heredada (android.app.Fragment). Para proyectos nuevos, se recomienda usar la API de Fragment de AndroidX.

Autor
Luigui Alexander Huanca Capira
Fechas

Fecha de creación: 2024-09-25
Última modificación: 2024-09-25
