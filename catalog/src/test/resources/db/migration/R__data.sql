delete
from book
where isbn in ('9781484228074', '0201633612');

insert into book (isbn, title, subtitle, authors, publisher, publication_year, categories, description, image_url,
                  number_of_pages, rating, price)
values ('9781484228074', 'Spring Boot 2', null, 'Michael Simons', 'dpunkt', 2018, null,
        'Spring Boot hat seit 2014 das Spring-Ökosystem revolutioniert und verdrängt in zunehmendem Maße "klassische" Spring-Anwendungen. Spring Boot ist kein neues Framework, sondern basiert auf Spring und dem Spring-Ökosystem. Es vereinfacht die Verwaltung von Abhängigkeiten und die Konfiguration des Spring- Frameworks. Spring Boot löst dabei Probleme, die einer effektiven und effizienten Produktivsetzung im Weg stehen, und bietet vielfältige Möglichkeiten, testgetrieben zu entwickeln. Spring Boot sollte die erste Wahl sein, Springbasierte Anwendungen zu entwickeln, unabhängig davon, ob es sich um Microservices handelt oder nicht. Dieses Buch bietet eine umfassende Einführung in die von Spring Boot unterstützten Spring-Module und -Technologien: - Webanwendungen - Reaktive Anwendungen - Security - Datenbanktechnologien - Caching - Tests und Dokumentation Darüber hinaus stellt es verschiedene Möglichkeiten vor, Spring-Boot-Anwendungen zu deployen, sowohl in klassischen als auch in Cloud- Szenarien. Hinweise auf Best Practices sowie eine Übersicht der zahlreichen Änderungen von Spring Boot 1 auf Version 2 runden das Buch ab.',
        'https://exlibris.azureedge.net/covers/9783/8649/0525/4/9783864905254xl.jpg',
        448, '*****', 39.24);

insert into book (isbn, title, subtitle, authors, publisher, publication_year, categories, description, image_url,
                  number_of_pages, rating, price)
values ('0201633612', 'Design Patterns', null, 'Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides',
        'Addision-Wesley', 1994, null,
        'Capturing a wealth of experience about the design of object-oriented software, four top-notch designers present a catalog of simple and succinct solutions to commonly occurring design problems. Previously undocumented, these 23 patterns allow designers to create more flexible, elegant, and ultimately reusable designs without having to rediscover the design solutions themselves.',
        'https://images-na.ssl-images-amazon.com/images/I/51szD9HC9pL._SX395_BO1,204,203,200_.jpg',
        416, '*****', 36.99);
