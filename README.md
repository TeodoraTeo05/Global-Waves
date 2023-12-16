# Proiect GlobalWaves  - Teodorescu Teodora-Nicola 325CA


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
  
   * user/

      User - este o clasa care  Inițializează un nou utilizator cu un nume de utilizator, vârstă și oraș. Metodele implementate aici sunt:

       - search: Permite căutarea în sistem bazată pe filtre și tipul de căutare.
       - select: Selectează un element din rezultatele căutării.
       - load: Încarcă o sursă audio pentru redare.
       - playPause: Pornește sau oprește redarea sursei audio.
       - repeat: Setează modul de repetare pentru redarea audio.
       - shuffle: Activează sau dezactivează modul amestec (shuffle) pentru redarea playlisturilor sau albumelor.
       - forward / backward: Înaintează sau retrocedează în cadrul unui podcast.
       - like: Marchează un cântec ca fiind preferat.
       - next / prev: Sări la următorul sau precedentul element audio.
       - createPlaylist: Creează o nouă playlistă.
       - addRemoveInPlaylist: Adaugă sau elimină un cântec dintr-o playlistă.
       - switchPlaylistVisibility: Schimbă vizibilitatea unei playliste.
       - showPlaylists: Afișează listele de redare ale utilizatorului.
       - follow: Permite urmărirea sau oprirea urmăririi unei playliste.
       - getPlayerStats: Obține statistici legate de redarea audio.
       - showPreferredSongs: Afișează lista cântecelor preferate.
       - getPreferredGenre: Determină genul muzical preferat al utilizatorului.
       - simulateTime: Simulează trecerea timpului în sistem.
       - switchConnectionStatus: Schimbă statusul de conectare al utilizatorului.
       - addAlbum / showAlbums / addEvent / addMerch: Metode legate de funcționalități artistice sau comerciale (prezente, dar nu implementate în mod activ pentru un utilizator obișnuit).

       Host - clasa care mosteneste clasa User, dar ofera implementari diferite pentru comenzile pe care doar un user de tip host le poate da, cum sunt cele care se ocupa de Podcasturi si de Announcements.

       Artist - clasa care mosteneste clasa User, dar ofera implementari diferite pentru comenzile pe care doar un user de tip host le poate da, cum sunt cele care se ocupa de Event si de Merch.
  

   * personals/

        ArtistEntry si HostEntry - clase care implementeaza mostenesc LibraryEntry si care sunt folosite pentru a retine informatii despre un artist sau un host.
        Announcement, Event si Merch - clase care retin pentru un host sau artist, biblioteca lor de annnouncements, merch si events, putand avea si functionalitati noi, precum la Event este o metoda care valideaza data introdusa.
      
   * pages/

       Page - clasa abstracta care contie constructorul ei si o metoda comuna cu clasele mostenite de ea.
         ArtistPage, HostPage, UserPage - clase care mostenesc clasa Page si care implementeaza metoda comuna din clasa Page, anume cea de printare a paginii curente, dar si metode noi, cum ar fi la ArtistPage, metoda care adauga un album in biblioteca artistului. Cum pentru fiecare tip de user, avem o pagina diferita, pentru o mai buna organizare, am optat pentru 3 clase.

   * collections/
       Album - clasa care implementeaza un album, avand o lista de melodii, alaturi de datele de input necesare. Aceasta mosteneste clasa AudioCollection., care la randul ei mosteneste clasa LibraryEntry.
       AlbumOutput si PodcastOutput - clase care asigura printrea in conformitate cu testele date, pentru o organizare mai eficienta.
  
   