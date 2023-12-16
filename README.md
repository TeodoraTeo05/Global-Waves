# Proiect GlobalWaves  - Teodorescu Teodora-Nicola

[//]: # (<div align="center"><img src="https://tenor.com/view/listening-to-music-spongebob-gif-8009182.gif" width="300px"></div>)

[//]: # ()
[//]: # (#### Assignment Link: [https://ocw.cs.pub.ro/courses/poo-ca-cd/teme/proiect/etapa1]&#40;https://ocw.cs.pub.ro/courses/poo-ca-cd/teme/proiect/etapa1&#41;)

[//]: # ()

## Skel Structure

* app/
   * utils/
   
        Admin - clasa care implementeaza un admin. Aceasta gestioneaza diverse entități în cadrul aplicației, inclusiv utilizatori, albume, melodii, podcast-uri, evenimente și produse comerciale. Aceasta urmează modelul de design Singleton pentru a asigura că doar o instanță a acestei clase este creată și utilizată în întreaga aplicație. Unele dintre functionalitatile acestei clase sunt: Gestionarea Utilizatorilor: Manevrarea operațiunilor legate de utilizatori, inclusiv adăugarea de noi utilizatori și recuperarea informațiilor acestora.
     
        - Gestionarea Melodiilor: Administrează melodii, permițând adăugarea și recuperarea datelor despre melodii;
        - Gestionarea Albumelor: Facilitează crearea și întreținerea albumelor, oferind și funcționalități pentru a recupera date despre albume și pentru top 5 albume bazate pe like-uri;
        - Gestionarea Podcast-urilor: Supraveghează gestionarea podcast-urilor, inclusiv adăugarea de noi podcast-uri și recuperarea informațiilor despre acestea;
        - Gestionarea Evenimentelor și a Produselor Comerciale: Gestionează evenimentele și produsele comerciale, inclusiv capacitatea de a adăuga noi intrări pentru fiecare;
        - Prelucrarea Intrărilor Utilizatorilor: Procesează diferite tipuri de intrări ale utilizatorilor pentru a actualiza starea aplicației corespunzător;
        - Funcționalitatea de Resetare a Datelor: Oferă posibilitatea de a reseta toate datele stocate la o stare inițială.
        
       CommandRunneer - clasa este responsabilă pentru gestionarea și executarea comenzilor în cadrul aplicației. Cateva dintre functionalitatile ei sunt:

        - Procesarea Comenzilor: Clasa gestionează diverse tipuri de comenzi, cum ar fi căutarea, redarea, pauza, și multe altele.
        - Gestionarea Stării Utilizatorilor: Verifică dacă utilizatorii sunt online sau offline și gestionează corespunzător comenzile.
        - Interacțiunea cu Clasa Admin: Folosește instanța Singleton a clasei Admin pentru a accesa și a modifica datele utilizatorilor și ale sistemului.
        -  Generarea de Răspunsuri: Folosește ObjectMapper pentru a crea obiecte JSON care reprezintă răspunsurile sistemului la comenzile utilizatorilor.

[//]: # (  * checker/ - checker files)

[//]: # (  * fileio/ - contains classes used to read data from the json files)

[//]: # (  * main/)

[//]: # (      * Main - the Main class runs the checker on your implementation. Add the entry point to your implementation in it. Run Main to test your implementation from the IDE or from command line.)

[//]: # (      * Test - run the main method from Test class with the name of the input file from the command line and the result will be written)

[//]: # (        to the out.txt file. Thus, you can compare this result with ref.)

[//]: # (* input/ - contains the tests and library in JSON format)

[//]: # (* ref/ - contains all reference output for the tests in JSON format)

[//]: # (<div align="center"><img src="https://tenor.com/view/homework-time-gif-24854817.gif" width="500px"></div>)
