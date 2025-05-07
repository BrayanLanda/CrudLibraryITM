## Diagrama ER Library
![book-system.png](../../Downloads/book-system.png)
# LogicCode
## Book
    publico clase Book
    privado entero id
    privado texto title
    privado texto author
    privado real price
    privado entero stock

    // Constructor
    publico metodo Book(entero id, texto title, texto author, real price, entero stock)
        esteobjeto.id = id
        esteobjeto.title = title
        esteobjeto.author = author
        esteobjeto.price = price
        esteobjeto.stock = stock
    finmetodo

    // Métodos Get y Set
    publico entero metodo obtenerId()
        retorne id
    finmetodo
    
    publico vacio metodo establecerId(entero id)
        esteobjeto.id = id
    finmetodo
    
    publico texto metodo obtenerTitle()
        retorne title
    finmetodo
    
    publico vacio metodo establecerTitle(texto title)
        esteobjeto.title = title
    finmetodo
    
    publico texto metodo obtenerAuthor()
        retorne author
    finmetodo
    
    publico vacio metodo establecerAuthor(texto author)
        esteobjeto.author = author
    finmetodo
    
    publico real metodo obtenerPrice()
        retorne price
    finmetodo
    
    publico vacio metodo establecerPrice(real price)
        esteobjeto.price = price
    finmetodo
    
    publico entero metodo obtenerStock()
        retorne stock
    finmetodo
    
    publico vacio metodo establecerStock(entero stock)
        esteobjeto.stock = stock
    finmetodo
    
    publico texto metodo toString()
        retorne "Book{id=" + id + ", title='" + title + "', author='" + author + "', price=" + price + ", stock=" + stock + "}"
    finmetodo
    finclase
## Customer
    publico clase Customer
    privado entero id
    privado texto name
    privado texto email
    privado texto phone

    // Constructor
    publico metodo Customer(entero id, texto name, texto email, texto phone)
        esteobjeto.id = id
        esteobjeto.name = name
        esteobjeto.email = email
        esteobjeto.phone = phone
    finmetodo

    // Métodos Get y Set
    publico entero metodo obtenerId()
        retorne id
    finmetodo
    
    publico vacio metodo establecerId(entero id)
        esteobjeto.id = id
    finmetodo
    
    publico texto metodo obtenerName()
        retorne name
    finmetodo
    
    publico vacio metodo establecerName(texto name)
        esteobjeto.name = name
    finmetodo
    
    publico texto metodo obtenerEmail()
        retorne email
    finmetodo
    
    publico vacio metodo establecerEmail(texto email)
        esteobjeto.email = email
    finmetodo
    
    publico texto metodo obtenerPhone()
        retorne phone
    finmetodo
    
    publico vacio metodo establecerPhone(texto phone)
        esteobjeto.phone = phone
    finmetodo
    
    publico texto metodo toString()
        retorne "Customer{id=" + id + ", name='" + name + "', email='" + email + "', phone='" + phone + "'}"
    finmetodo
    finclase
## Order
    publico clase Order
    privado entero id
    privado Customer customer
    privado Book book
    privado entero quantity
    privado real totalPrice

    // Constructor
    publico metodo Order(entero id, Customer customer, Book book, entero quantity)
        esteobjeto.id = id
        esteobjeto.customer = customer
        esteobjeto.book = book
        esteobjeto.quantity = quantity
        esteobjeto.totalPrice = book.obtenerPrice() * quantity
    finmetodo

    // Métodos Get y Set
    publico entero metodo obtenerId()
        retorne id
    finmetodo
    
    publico vacio metodo establecerId(entero id)
        esteobjeto.id = id
    finmetodo
    
    publico Customer metodo obtenerCustomer()
        retorne customer
    finmetodo
    
    publico vacio metodo establecerCustomer(Customer customer)
        esteobjeto.customer = customer
    finmetodo
    
    publico Book metodo obtenerBook()
        retorne book
    finmetodo
    
    publico vacio metodo establecerBook(Book book)
        esteobjeto.book = book
    finmetodo
    
    publico entero metodo obtenerQuantity()
        retorne quantity
    finmetodo
    
    publico vacio metodo establecerQuantity(entero quantity)
        esteobjeto.quantity = quantity
    finmetodo
    
    publico real metodo obtenerTotalPrice()
        retorne totalPrice
    finmetodo
    
    publico vacio metodo establecerTotalPrice(real totalPrice)
        esteobjeto.totalPrice = totalPrice
    finmetodo
    
    publico texto metodo toString()
        retorne "Order{id=" + id + ", customer=" + customer.obtenerName() + ", book=" + book.obtenerTitle() + ", quantity=" + quantity + ", totalPrice=" + totalPrice + "}"
    finmetodo
    finclase
## BookController
    publico clase BookController
    privado Book[] books
    privado entero count

    // Constructor
    publico metodo BookController(entero capacity)
        books = nuevo Book[capacity]
        count = 0
    finmetodo

    // Método para agregar libro
    publico vacio metodo addBook(Book book)
        si(count >= longitud(books))
            imprima("⚠️ The library is full. Cannot add more books.")
            retorne
        finsi
        books[count] = book
        count = count + 1
        imprima("✅ Book added successfully.")
    finmetodo

    // Método para listar libros
    publico vacio metodo listBooks()
        si(count == 0)
            imprima("⚠️ No books available.")
            retorne
        finsi
        para(entero i = 0; i < count; i = i + 1)
            imprima(books[i])
        finpara
    finmetodo

    // Método para actualizar libro
    publico boleano metodo updateBook(entero id, texto newTitle, texto newAuthor, real newPrice, entero newStock)
        para(entero i = 0; i < count; i = i + 1)
            si(books[i].obtenerId() == id)
                books[i].establecerTitle(newTitle)
                books[i].establecerAuthor(newAuthor)
                books[i].establecerPrice(newPrice)
                books[i].establecerStock(newStock)
                imprima("✅ Book updated successfully.")
                retorne verdadero
            finsi
        finpara
        imprima("❌ Book not found.")
        retorne falso
    finmetodo

    // Método para eliminar libro
    publico boleano metodo deleteBook(entero id)
        para(entero i = 0; i < count; i = i + 1)
            si(books[i].obtenerId() == id)
                // Desplazar elementos para llenar el espacio
                para(entero j = i; j < count - 1; j = j + 1)
                    books[j] = books[j + 1]
                finpara
                books[count - 1] = nulo  // Limpiar última posición
                count = count - 1
                imprima("✅ Book deleted successfully.")
                retorne verdadero
            finsi
        finpara
        imprima("❌ Book not found.")
        retorne falso
    finmetodo

    // Método para buscar libro por ID
    publico Book metodo findBookById(entero id)
        para(entero i = 0; i < count; i = i + 1)
            si(books[i].obtenerId() == id)
                retorne books[i]
            finsi
        finpara
        retorne nulo
    finmetodo

    // Método para ordenar libros por precio
    publico vacio metodo sortBooksByPrice()
        si(count == 0)
            imprima("⚠️ No books to sort.")
            retorne
        finsi
        para(entero i = 0; i < count - 1; i = i + 1)
            para(entero j = 0; j < count - i - 1; j = j + 1)
                si(books[j].obtenerPrice() > books[j + 1].obtenerPrice())
                    // Intercambiar libros
                    Book temp = books[j]
                    books[j] = books[j + 1]
                    books[j + 1] = temp
                finsi
            finpara
        finpara
        imprima("✅ Books sorted by price (ascending).")
    finmetodo

    // Método para ordenar libros por título
    publico vacio metodo sortByTitle()
        para(entero i = 0; i < count - 1; i = i + 1)
            para(entero j = 0; j < count - i - 1; j = j + 1)
                si(books[j].obtenerTitle().comparar(books[j + 1].obtenerTitle()) > 0)
                    // Intercambiar
                    Book temp = books[j]
                    books[j] = books[j + 1]
                    books[j + 1] = temp
                finsi
            finpara
        finpara
        imprima("✅ Books sorted by title.")
    finmetodo
    finclase
## View Library
    publico clase LibraryView
    privado final BookController bookController
    privado final CustomerController customerController
    privado final OrderController orderController

    // Constructor
    publico metodo LibraryView()
        esteobjeto.bookController = nuevo BookController(20)
        esteobjeto.customerController = nuevo CustomerController()
        esteobjeto.orderController = nuevo OrderController()
    finmetodo

    // Método principal
    publico vacio metodo start()
        entero option
        hacer
            imprima("\n===== LIBRARY MANAGEMENT SYSTEM =====")
            imprima("1️⃣ Manage Books")
            imprima("2️⃣ Manage Customers")
            imprima("3️⃣ Manage Orders")
            imprima("0️⃣ Exit")
            imprima("Choose an option: ")
            option = leerEntero()

            segun(option)
                caso 1:
                    manageBooks()
                caso 2:
                    manageCustomers()
                caso 3:
                    manageOrders()
                caso 0:
                    imprima("👋 Exiting...")
                en otro caso:
                    imprima("❌ Invalid option. Try again.")
            finsegun
        mientras(option != 0)
    finmetodo

    // ===== MENÚ DE LIBROS =====
    privado vacio metodo manageBooks()
        entero option
        hacer
            imprima("\n--- Manage Books ---")
            imprima("1️⃣ Add Book")
            imprima("2️⃣ List Books")
            imprima("3️⃣ Update Book")
            imprima("4️⃣ Delete Book")
            imprima("5️⃣ Sort Books by Price")
            imprima("6️⃣ Sort Books by Title")
            imprima("0️⃣ Back")
            imprima("Choose an option: ")
            option = leerEntero()

            segun(option)
                caso 1:
                    addBook()
                caso 2:
                    bookController.listBooks()
                caso 3:
                    updateBook()
                caso 4:
                    deleteBook()
                caso 5:
                    bookController.sortBooksByPrice()
                    bookController.listBooks()
                caso 6:
                    bookController.sortByTitle()
                    bookController.listBooks()
                caso 0:
                    imprima("🔙 Back to main menu.")
                en otro caso:
                    imprima("❌ Invalid option.")
            finsegun
        mientras(option != 0)
    finmetodo

    privado vacio metodo addBook()
        imprima("Enter ID: ")
        entero id = leerEntero()
        imprima("Enter Title: ")
        texto title = leerTexto()
        imprima("Enter Author: ")
        texto author = leerTexto()
        imprima("Enter Price: ")
        real price = leerReal()
        imprima("Enter Stock: ")
        entero stock = leerEntero()

        Book book = nuevo Book(id, title, author, price, stock)
        bookController.addBook(book)
    finmetodo

    privado vacio metodo updateBook()
        imprima("Enter Book ID to update: ")
        entero id = leerEntero()
        imprima("New Title: ")
        texto title = leerTexto()
        imprima("New Author: ")
        texto author = leerTexto()
        imprima("New Price: ")
        real price = leerReal()
        imprima("New Stock: ")
        entero stock = leerEntero()

        bookController.updateBook(id, title, author, price, stock)
    finmetodo

    privado vacio metodo deleteBook()
        imprima("Enter Book ID to delete: ")
        entero id = leerEntero()
        boleano removed = bookController.deleteBook(id)
        si(removed)
            imprima("✅ Book deleted.")
        sino
            imprima("❌ Book not found.")
        finsi
    finmetodo

    // ===== MENÚ DE CLIENTES =====
    privado vacio metodo manageCustomers()
        entero option
        hacer
            imprima("\n--- Manage Customers ---")
            imprima("1️⃣ Add Customer")
            imprima("2️⃣ List Customers")
            imprima("3️⃣ Update Customer")
            imprima("4️⃣ Delete Customer")
            imprima("0️⃣ Back")
            imprima("Choose an option: ")
            option = leerEntero()

            segun(option)
                caso 1:
                    addCustomer()
                caso 2:
                    customerController.listCustomers()
                caso 3:
                    updateCustomer()
                caso 4:
                    deleteCustomer()
                caso 0:
                    imprima("🔙 Back to main menu.")
                en otro caso:
                    imprima("❌ Invalid option.")
            finsegun
        mientras(option != 0)
    finmetodo

    privado vacio metodo addCustomer()
        imprima("Enter ID: ")
        entero id = leerEntero()
        imprima("Enter Name: ")
        texto name = leerTexto()
        imprima("Enter Email: ")
        texto email = leerTexto()
        imprima("Enter Phone: ")
        texto phone = leerTexto()

        Customer customer = nuevo Customer(id, name, email, phone)
        customerController.addCustomer(customer)
    finmetodo

    privado vacio metodo updateCustomer()
        imprima("Enter Customer ID to update: ")
        entero id = leerEntero()
        imprima("New Name: ")
        texto name = leerTexto()
        imprima("New Email: ")
        texto email = leerTexto()
        imprima("New Phone: ")
        texto phone = leerTexto()

        customerController.updateCustomer(id, name, email, phone)
    finmetodo

    privado vacio metodo deleteCustomer()
        imprima("Enter Customer ID to delete: ")
        entero id = leerEntero()
        boleano removed = customerController.deleteCustomer(id)
        si(removed)
            imprima("✅ Customer deleted.")
        sino
            imprima("❌ Customer not found.")
        finsi
    finmetodo

    // ===== MENÚ DE PEDIDOS =====
    privado vacio metodo manageOrders()
        entero option
        hacer
            imprima("\n--- Manage Orders ---")
            imprima("1️⃣ Create Order")
            imprima("2️⃣ List Orders")
            imprima("3️⃣ Delete Order")
            imprima("0️⃣ Back")
            imprima("Choose an option: ")
            option = leerEntero()

            segun(option)
                caso 1:
                    createOrder()
                caso 2:
                    orderController.listOrders()
                caso 3:
                    deleteOrder()
                caso 0:
                    imprima("🔙 Back to main menu.")
                en otro caso:
                    imprima("❌ Invalid option.")
            finsegun
        mientras(option != 0)
    finmetodo

    privado vacio metodo createOrder()
        imprima("Enter Order ID: ")
        entero orderId = leerEntero()
        imprima("Enter Customer ID: ")
        entero customerId = leerEntero()
        imprima("Enter Book ID: ")
        entero bookId = leerEntero()
        imprima("Enter Quantity: ")
        entero quantity = leerEntero()

        Customer customer = customerController.findCustomerById(customerId)
        Book book = bookController.findBookById(bookId)

        si(customer == nulo o book == nulo)
            imprima("❌ Customer or Book not found.")
            retorne
        finsi

        si(book.obtenerStock() < quantity)
            imprima("❌ Not enough stock.")
            retorne
        finsi

        book.establecerStock(book.obtenerStock() - quantity)  // Reducir stock
        Order order = nuevo Order(orderId, customer, book, quantity)
        orderController.addOrder(order)
    finmetodo

    privado vacio metodo deleteOrder()
        imprima("Enter Order ID to delete: ")
        entero id = leerEntero()
        boleano removed = orderController.deleteOrder(id)
        si(removed)
            imprima("✅ Order deleted.")
        sino
            imprima("❌ Order not found.")
        finsi
    finmetodo

    // ===== Métodos auxiliares =====
    privado entero metodo leerEntero()
        retorne 0  // Lógica para leer entero
    finmetodo

    privado real metodo leerReal()
        retorne 0.0  // Lógica para leer real
    finmetodo

    privado texto metodo leerTexto()
        retorne ""  // Lógica para leer texto
    finmetodo
    finclase

## Main
    publico clase Principal
        publico estatico vacio principal()
            LibraryView libraryView = nuevo LibraryView()
        libraryView.start()
        finprincipal
    finclase