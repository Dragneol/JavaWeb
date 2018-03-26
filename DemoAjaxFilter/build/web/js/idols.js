/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var btn = $('#btn-idols');
var table = $('#table-idols');

var tbody = table.children('tbody');

var idols;
btn.on('click', function () {
//    alert("click");
    var request = $.ajax({
        url: 'getIdols',
        method: 'GET',
        cache: false
    });

    request.done(function (data) {
        idols = JSON.parse(data);
        idols.forEach(function (idol) {
            tbody.append(createRow(idol));
        });
    });

    request.fail(function (msg) {
        console.error(msg);
    });
});

createImg = function (url) {
    var img = $('<img />');
    img.attr('class', 'rounded');
    img.attr('src', url);
    return img;
};

createCol = function (text) {
    var col = $('<td></td>');
    col.text(text);
    return col;
};

createRow = function (idols) {
    var row = $('<tr></tr>');
    row.append(createCol(idols.name));
    row.append(createCol().append(createImg(idols.imgUrl)));
    row.append(createCol(idols.boob));
    row.append(createCol(idols.wip));
    row.append(createCol(idols.hip));
    return row;
};