
function getProducts() {

    $.ajax({
        url: 'https:/localhost:8080/StockMavenProject/api/products/consultAll',
        type: 'GET',
        contentType: 'application/json',
        success: function (data) {
            console.log(data);

           

            // for (let i=0 ; i < data.length; i++) {
            //             const element = data[i];
            //             var produtos = "<tr><td>" + data[i].valorDesconto + "</td><td>" + data[i].iva + "</td><td>" + data[i].pvp + "</td><td>" + data[i].id + "</td></tr>";
    
            //             $('#tabelaproduto').append(produtos);
            //         }


            // if (data.length > 10) {
            //     for (let i = data.length - 11; i < data.length; i++) {
            //         const element = data[i];
            //         var produtos = "<tr><td>" + data[i].discountValue + "</td><td>" + data[i].iva + "</td><td>" + data[i].pvp + "</td><td>" + data[i].id + "</td></tr>";

            //         $('#tabelaproduto').append(produtos);
            //     }
            // }
            // else {
            //     for (let i = 0; i < data.length; i++) {

            //         var produtos = "<tr><td>" + data[i].discountValue + "</td><td>" + data[i].iva + "</td><td>" + data[i].pvp + "</td><td>" + data[i].id + "</td></tr>";

            //         $('#tabelaproduto').append(produtos);

            //     }

            // }

        }
    });
}
getProducts()

// function getShelves() {
//     $.ajax({
//         url: 'https://mcupacademy.herokuapp.com/api/Shelves',
//         type: 'GET',
//         contentType: 'application/json',
//         success: function (data) {
        
//             if (data.length > 10) {
//                 for (let i = data.length - 11; i < data.length; i++) {
//                     const element = data[i];
//                     var shelves = "<tr><td>" + data[i].capacity + "</td><td>" + data[i].rentPrice + "</td><td>" + data[i].id + "</td><td>" + data[i].productId + "</td></tr>";
//                     $('#tabelaprateleira').append(shelves);
//                 }
//             }
//             else{

//                 for (let i = 0; i < data.length; i++) {

//                     var shelves = "<tr><td>" + data[i].capacity + "</td><td>" + data[i].rentPrice + "</td><td>" + data[i].id + "</td><td>" + data[i].productId + "</td></tr>";
//                     $('#tabelaprateleira').append(shelves);
//                 }
//             }
//         }
//     });
// };

// getShelves()




// function addProducts() {


//     var product = new Product($('#discountValue').val(), $('#iva').val(), $('#pvp').val());

//     $.ajax({
//         url: 'localhost:8080/StockMavenProject/api/products/new',
//         type: 'POST',
//         contentType: 'application/json',
//         data: JSON.stringify(product),
//         success: function (newproduct) {
//             console.log(newproduct);
//             $("#salvar").click(window.location.reload());
//         }
        
//     });
    
// };


// function addShelves() {


//     var shelf = new Shelf($('#capacity').val(), $('#rentPrice').val(), $('#productId').val());

//     $.ajax({
//         url: 'https://mcupacademy.herokuapp.com/api/Shelves',
//         type: 'POST',
//         contentType: 'application/json',
//         data: JSON.stringify(shelf),
//         success: function (newshelf) {
//             console.log(newshelf);~
//             $("#salvar2").click(window.location.reload());
//         }
//     });
// };






function getProductsbyId() {
    var pesquisar = $('#iptpes').val();

    $.ajax({
        url: `localhost:8080/StockMavenProject/api/products/consult/${pesquisar}`,
        type: 'GET',
        contentType: 'application/json',
        success: function (data) {
            console.log("id=" + data);


            var showdata = "<tr><td>" + data.discountValue + "</td><td>" + data.iva + "</td><td>" + data.pvp + "</td></tr>";

            $("#tableprodutobyid").fadeIn();
            $("#tableprodutobyid").append(showdata);
        }
    });

};

// function getShelvesbyId() {
//     var pesquisar2 = $('#iptpes2').val();

//     $.ajax({
//         url: `https://mcupacademy.herokuapp.com/api/Shelves/${pesquisar2}`,
//         type: 'GET',
//         contentType: 'application/json',
//         success: function (data) {
//             console.log("id=" + data);
//             var showdata2 = "<tr><td>" + data.capacity + "</td><td>" + data.rentPrice + "</td><td>" + data.productId + "</td></tr>";

//             $("#tableshelfbyid").fadeIn();
//             $("#tableshelfbyid").append(showdata);

//         }
//     });

// };

// function addreplaceProducts() {
//     var pesquisar3 = $('#iptreplaceidproduto').val();

//     var productreplace = new Product($('#replacedv').val(), $('#replaceiva').val(), $('#replacepvp').val());

//     $.ajax({
//         url: `https://mcupacademy.herokuapp.com/api/Products/${pesquisar3}`,
//         type: 'PUT',
//         contentType: 'application/json',
//         data: JSON.stringify(productreplace),
//         success: function (replace) {
//             console.log(replace);
//         }
//     });
// };

// function addreplaceShelves() {
//     var pesquisar4 = $('#iptreplaceidshelf').val();

//     var shelfreplace = new Product($('#replacecapacity').val(), $('#replacerentprice').val(), $('#replaceprodutoid').val());

//     $.ajax({
//         url: `https://mcupacademy.herokuapp.com/api/Shelves/${pesquisar4}`,
//         type: 'PUT',
//         contentType: 'application/json',
//         data: JSON.stringify(shelfreplace),
//         success: function (replace) {
//             console.log(replace);
//         }
//     });
// };
// function deleteProducts() {
//     var pesquisar5 = $('#iptdeleteidproduto').val();
//     console.log(pesquisar5);


//     $.ajax({
//         url: `https://mcupacademy.herokuapp.com/api/Products/${pesquisar5}`,
//         type: 'DELETE',
//         contentType: 'application/json',

//         success: function (apagar) {

//         }
//     });
// };

// function deleteShelves() {
//     var pesquisar6 = $('#iptdeleteidshelf').val();

//     $.ajax({
//         url: `https://mcupacademy.herokuapp.com/api/Shelves/${pesquisar6}`,
//         type: 'DELETE',
//         contentType: 'application/json',

//         success: function (apagar) {

//         }
//     });
// };






