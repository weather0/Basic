// calendar.js


let table = '<table border=1>';

const days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat'];

table += '<tr>';

for (let j = 0; j < 7; j++) {
  table += '<th>' + days[j] + '</th>';
}
table += '</tr><tr>';

for (let i = 1; i <= 31; i++) {
  if (i % 7 == 0) {
    table += '<td>' + i + '</td></tr><tr>'
  } else {
    table += '<td>' + i + '</td>'
  }
}
table += '</tr></table>';

document.write(table);