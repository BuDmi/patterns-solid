1. Чтобы исключить магические числа, например в методе run введены константы SHOW_ALL_SHOP_PRODUCT, SHOW_FILTERED_PRODUCTS и тд для того,
чтобы было понятно в switch по каждому case - что за кейс


2. Принцип DRY используется, например выносе кода в метод printMenuToAddProduct класса Shop


3. Принципы SOLID:

3.1) Принцип единственной ответственности - каждый класс выполняет только тот функционал, для которого предназначен (
   ConsoleMainMenu - рисует меню в консоли
   ConsoleInputProcessor - обрабатывает клавиши в консоли
   Producer - описывает производителя
   Product - продукт
   ProductBasket - продуктовая корзина
   ProductFilter - проводит фильтрацию продуктов
   Shop - организовывает работу магазина

3.2) Принцип открытости/закрытости

3.3) Принцип замены Барбары Лисков - в классе Shop есть методы, аналогичные по названию ConsoleMainMenu. Но в ConsoleMainMenu они выполняю функцию
   только вывода меню на экран, в Shop - дополнительно взаимодействие с пользователем (например, printMenuToAddProduct)

3.4) Принцип сегрегации интерфейсов - интерфейсы меню разделены на 3 разных (MainMenu, FilterMenu, BasketMenu), поскольку не во всех
   магазинах может быть, например, меню корзины покупок (например сайт чисто для ознакомления с ассортиментами)

3.5) Принцип инверсии зависимостей функционал вывода меню для пользователя зависит от абстракций, предоставляемых интерфейсом
   (Menu). Сейчас у нас всё выводится в консоль (класс ConsoleMainMenu), если мы надумаем выводить на веб-странице,
   то достаточно будет просто подменить класс реализации и всё