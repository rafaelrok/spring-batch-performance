drop table if exists products;
CREATE TABLE products 
  ( 
     id              INTEGER NOT NULL PRIMARY KEY, 
     name            VARCHAR(26) NOT NULL, 
     description     VARCHAR(492) NOT NULL, 
     image           VARCHAR(31) NOT NULL, 
     price           NUMERIC(8, 2) NOT NULL, 
     discount_amount NUMERIC(8, 2) NOT NULL, 
     status          VARCHAR(4) NOT NULL,
     categories      VARCHAR(255)
  ); 
  
drop table if exists new_products;
CREATE TABLE new_products 
  ( 
     id              INTEGER NOT NULL PRIMARY KEY, 
     name            VARCHAR(26) NOT NULL, 
     description     VARCHAR(492) NOT NULL, 
     image           VARCHAR(31) NOT NULL, 
     price           NUMERIC(8, 2) NOT NULL, 
     discount_amount NUMERIC(8, 2) NOT NULL, 
     status          VARCHAR(4) NOT NULL,
     categories      VARCHAR(255)
  ); 
  

INSERT INTO products 
            (id, 
             name, 
             description, 
             image, 
             price, 
             discount_amount, 
             status) 
VALUES      (1, 
             'Awesome Aluminum Watch', 
'Quisquam mollitia tantum depromo tamisium vilitas repellat sordeo verto ventito modi terebro vulariter asporto amoveo beneficium occaecati amissio speciosus a conforto vigilo esse animi et pectus ara qui claustrum sed provident calco deleniti capto comedo amiculum accusator centum et reiciendis confido allatus sopor tunc aestivus solum absconditus amplexus copia depulso bibo vacuus ocer cogito talis cohors delego synagoga id strenuus abeo summisse.'
             , 
'https://loremflickr.com/250/250', 
37303.65, 
11937.06, 
'true'); 

INSERT INTO products 
            (id, 
             name, 
             description, 
             image, 
             price, 
             discount_amount, 
             status) 
VALUES      (2, 
             'Incredible Paper Wallet', 
'Defero comptus universe tabgo cotidie surculus velit teres uter cibus vitae theatrum id vigilo coniecto spoliatio quos suffoco quia brevis curso pauper sumo velum culpo autem aut alo terminatio ambitus tero candidus varius perspiciatis dignissimos viridis accedo defaeco trucido ars aut aptus aut ara omnis.'
             , 
'https://loremflickr.com/250/250', 
14746.4, 
7073.64, 
'true'); 

INSERT INTO products 
            (id, 
             name, 
             description, 
             image, 
             price, 
             discount_amount, 
             status) 
VALUES      (3, 
             'Incredible Rubber Knife', 
'Varietas accipio tego vel reprehenderit ademptio acerbitas titulus termes et sublime et adaugeo aut triginta atque cupio umquam tibi vicissitudo tametsi capto concido considero valeo vulgaris demens et collum commodo crinis villa tepesco nesciunt vereor comprehendo depulso adsidue caelestis conscendo placeat adulescens adulatio copiose tutis varius bene aggredior sunt supellex tabula.'
             , 
'https://loremflickr.com/250/250', 
33688.02, 
29188.33, 
'true'); 

INSERT INTO products 
            (id, 
             name, 
             description, 
             image, 
             price, 
             discount_amount, 
             status) 
VALUES      (4, 
             'Incredible Cotton Pants', 
'Eum tripudio patria amaritudo titulus tot curis aperte tenax pecunia quia quasi theatrum usitas tollo quaerat defungo comis vel annus dens voluptatem dolorem depereo cilicium esse ambitus spes quos defero taedium deprecator vobis ut tabgo coepi capio vomer nulla demitto sonitus conforto colloco magni suscipio acerbitas artificiose uter consectetur apostolus vaco aegrus acer.'
             , 
'https://loremflickr.com/250/250', 
34136.03, 
1547.11, 
'true'); 

INSERT INTO products 
            (id, 
             name, 
             description, 
             image, 
             price, 
             discount_amount, 
             status) 
VALUES      (5, 
             'Durable Copper Hat', 
'Omnis tremo voluptatibus aggredior denuncio subseco depromo sufficio accusamus volva voluptatem cognomen suffragium est thalassinus admoneo apostolus trucido volup quis damno tergum cervus voluptates demens curis vere perspiciatis autus celebrer tenus alo vero tepesco ut sed.'
             , 
'https://loremflickr.com/250/250', 
5715.92, 
2005.65, 
'true'); 

INSERT INTO products 
            (id, 
             name, 
             description, 
             image, 
             price, 
             discount_amount, 
             status) 
VALUES      (6, 
             'Enormous Cotton Wallet', 
'Suspendo thesaurus aegrus vitium virgo minima sed comprehendo impedit perferendis pecunia validus magnam alo certo nulla communis valetudo aestas pauper colloco adiuvo suadeo abutor sustineo culpa arcus vapulus asporto suasoria vehemens uter tui villa optio substantia doloremque amo textilis exercitationem avarus tredecim corrigo conforto quas commemoro conatus turpis crebro tricesimus autem aetas.'
             , 
'https://loremflickr.com/250/250', 
33051.41, 
1847.99, 
'true'); 

INSERT INTO products 
            (id, 
             name, 
             description, 
             image, 
             price, 
             discount_amount, 
             status) 
VALUES      (7, 
             'Gorgeous Bronze Bottle', 
'Degero vita est cogito cum vitiosus mollitia attonbitus sunt cauda atrocitas balbus tepesco minima viriliter qui deorsum clam abduco demonstro et verbum acervus advenio talis quasi studio viduo vis voro vetus depromo unus voluptas adinventitias adfectus pecto.'
             , 
'https://loremflickr.com/250/250', 
33516.43, 
5608.86, 
'true'); 

INSERT INTO products 
            (id, 
             name, 
             description, 
             image, 
             price, 
             discount_amount, 
             status) 
VALUES      (8, 
             'Practical Granite Bag', 
'Ultra annus theatrum autem uterque contabesco labore patrocinor vehemens colligo vinco aegrus tertius viriliter verbera adopto est auctor tonsor confugo universe sequi et sumo bis vaco caute ulterius aliquam ut impedit.'
             , 
'https://loremflickr.com/250/250', 
23901.33, 
3458.91, 
'true'); 

INSERT INTO products 
            (id, 
             name, 
             description, 
             image, 
             price, 
             discount_amount, 
             status) 
VALUES      (9, 
             'Rustic Marble Coat', 
'Casso aeneus in studio altus bestia amor deleo sit absque vapulus laudantium claro calco tristis theologus curso porro acquiro assentator deorsum colloco compello officiis tabernus aurum thema stillicidium tunc cenaculum degusto adamo verbum umquam ademptio ut causa deprecator arceo trucido ulterius ea damnatio ventito suppono concido deputo adfero solutio curriculum subito talis doloremque excepturi aut depereo corporis accusantium odio vero pecto velit damno et utroque tergiversatio.'
             , 
'https://loremflickr.com/250/250', 
29723.91, 
14245.75, 
'true'); 

INSERT INTO products 
            (id, 
             name, 
             description, 
             image, 
             price, 
             discount_amount, 
             status) 
VALUES      (10, 
             'Lightweight Wool Shoes', 
'Appello voluptatem clam consequatur alius deorsum audentia tamdiu adulescens tremo vito eum decor fugiat averto qui tutamen a tandem omnis tardus quae capio conspergo comis currus suspendo adversus tripudio abstergo dignissimos nam crebro demitto occaecati vorax absum vinum contego atqui paulatim suasoria versus dolorum angelus avoco coadunatio commodi quam conqueror corporis fuga argumentum vel tabernus apud in admitto subseco aggero ulciscor abutor ullus aperio maiores summisse libero.'
             , 
'https://loremflickr.com/250/250', 
8936.79, 
7437.7, 
'true'); 

INSERT INTO products 
            (id, 
             name, 
             description, 
             image, 
             price, 
             discount_amount, 
             status) 
VALUES      (11, 
             'Gorgeous Iron Lamp', 
'Sum angustus sunt antea denique terebro in tibi vae recusandae coadunatio laborum tardus audax stips esse surculus cometes adopto statua suggero vicissitudo apostolus celer complectus turpis annus comparo perspiciatis delinquo succurro utpote omnis sordeo porro tutis taedium voluptatem ipsa acerbitas suscipio consuasor aveho tubineus cohaero admitto et voluptas nihil aliqua stella spes accusator sonitus caute bis vomito vitiosus audeo uxor aspernatur fugiat tui.'
             , 
'https://loremflickr.com/250/250', 
3026.6, 
157.57, 
'true'); 

INSERT INTO products 
            (id, 
             name, 
             description, 
             image, 
             price, 
             discount_amount, 
             status) 
VALUES      (12, 
             'Lightweight Granite Bottle', 
'Carpo sunt explicabo tollo vero ultra aut colo acidus solum quasi substantia natus caterva curto beneficium minus avaritia tam vulticulus non audax vesica adversus aetas ait blandior debilito adimpleo id stella undique sed vobis tamen capillus suus tabella vester in chirographum carmen centum vulgus sophismata ut debitis voluptatem vulgo tamisium voluptatum conicio uterque convoco nostrum et audio callide aperte ipsam versus amaritudo.'
             , 
'https://loremflickr.com/250/250', 
21170.79, 
2886.15, 
'true'); 

INSERT INTO products 
            (id, 
             name, 
             description, 
             image, 
             price, 
             discount_amount, 
             status) 
VALUES      (13, 
             'Gorgeous Aluminum Plate', 
'Torrens virgo veniam coniecto carpo accendo adfero demoror vapulus inventore aestivus at qui voluptatem voro fugiat admoveo umerus ipsum vereor vomer aut amitto creta molestiae angulus temeritas comptus adultus anser comprehendo caterva demulceo tristis autem patior cubitum maiores triumphus adulescens deprimo desipio vulnus omnis summa verto currus degero corporis vinum peior cenaculum demergo officia uxor.'
             , 
'https://loremflickr.com/250/250', 
36256.99, 
25357.09, 
'true'); 

INSERT INTO products 
            (id, 
             name, 
             description, 
             image, 
             price, 
             discount_amount, 
             status) 
VALUES      (14, 
             'Durable Marble Shirt', 
'Quo venio tam adfectus clamo voluptas anser delego earum valde testimonium adflicto cum peior ipsum addo validus unus aegrus apto amaritudo absens turpis vis coruscus color certe cunctatio venustas ipsam averto dolores caterva fuga angustus via creber cursim cognomen claro voluptate aufero veniam est tollo virtus dolores.'
             , 
'https://loremflickr.com/250/250', 
2438.37, 
728.27, 
'true'); 

INSERT INTO products 
            (id, 
             name, 
             description, 
             image, 
             price, 
             discount_amount, 
             status) 
VALUES      (15, 
             'Synergistic Leather Shirt', 
'Vulariter demergo vel celer civitas terreo considero earum socius cognatus tumultus adficio qui sonitus suffoco defigo tamquam vesper ademptio spiculum viridis thymum ustulo credo ut quis voluptates usitas.'
             , 
'https://loremflickr.com/250/250', 
26262.94, 
23299.17, 
'true'); 

INSERT INTO products 
            (id, 
             name, 
             description, 
             image, 
             price, 
             discount_amount, 
             status) 
VALUES      (16, 
             'Enormous Rubber Pants', 
'Capillus laborum curto vomica sumptus deorsum conservo aegre spargo civitas desidero adflicto aut ut nisi audio maiores sumo tamen alioqui adimpleo fuga demulceo turpe cohors et adeo sodalitas copia administratio toties contigo vae similique complectus centum cohibeo demergo uter aveho statim terminatio paulatim.'
             , 
'https://loremflickr.com/250/250', 
3711.9, 
1758.27, 
'true'); 

INSERT INTO products 
            (id, 
             name, 
             description, 
             image, 
             price, 
             discount_amount, 
             status) 
VALUES      (17, 
             'Rustic Rubber Table', 
'Inventore adhuc terminatio verus delectatio dolor minus avarus textilis suppono cubitum patria veniam acies adaugeo avaritia clementia verecundia validus vallum arca combibo debeo theatrum autem agnosco reiciendis appositus aiunt ut subnecto cilicium quibusdam atrox vel adultus omnis demo tabgo fugiat adhaero cognatus inflammatio quisquam verbera autem aperio pariatur doloremque.'
             , 
'https://loremflickr.com/250/250', 
15331.77, 
6478.77, 
'true'); 

INSERT INTO products 
            (id, 
             name, 
             description, 
             image, 
             price, 
             discount_amount, 
             status) 
VALUES      (18, 
             'Intelligent Plastic Plate', 
'Administratio tabesco praesentium qui desolo statua vis studio delego suscipio toties super quia vilis crastinus odio cupiditate altus annus supplanto tricesimus vos tollo pariatur adnuo tergeo carpo ceno apparatus vel turpis decumbo comminor aggredior calcar considero caste cicuta deleo numquam placeat solio aut aeternus ultra quis et vulticulus est vinco ea cunabula temeritas curto spero vero usitas vix quasi textilis.'
             , 
'https://loremflickr.com/250/250', 
32846.44, 
6121.1, 
'true'); 

INSERT INTO products 
            (id, 
             name, 
             description, 
             image, 
             price, 
             discount_amount, 
             status) 
VALUES      (19, 
             'Gorgeous Copper Lamp', 
'Damnatio suus demonstro depulso villa colo verbum vinitor beneficium dolorum ut sublime qui articulus aspernatur canto conturbo quo uredo explicabo accedo vel verumtamen amissio atqui adfectus ante volva depromo delibero surgo ager conspergo testimonium tamisium consequatur assentator.'
             , 
'https://loremflickr.com/250/250', 
33138.66, 
3180.85, 
'true'); 

INSERT INTO products 
            (id, 
             name, 
             description, 
             image, 
             price, 
             discount_amount, 
             status) 
VALUES      (20, 
             'Heavy Duty Granite Watch', 
'Sumptus triduana deinde templum tibi carpo vigor certo adamo sono auxilium abscido cultura esse teres contra et aestus degenero adsum aut avaritia vapulus defluo complectus viriliter aut vestigium clarus ut solio repellendus damno cornu voro varius ocer voluptatum consequatur antea conqueror comminor ustulo omnis tabula absconditus crinis ventito in ullam voluptatem acer amicitia stella ago timor turpe apud cum doloribus quo cresco cohibeo incidunt sint avoco summa asporto.'
             , 
'https://loremflickr.com/250/250', 
5866.02, 
915.31, 
'true'); 