//var HttpClient = function() {
//    this.get = function(aUrl, aCallback) {
//    var anHttpRequest = new XMLHttpRequest();
//    anHttpRequest.onreadystatechange  = function(){
//    if (anHttpRequest.readyState == 4 && anHttpRequest.status == 200)
//        aCallBack(anHttpRequest.responseText);
//        }
//
//        anHttpRequest.open("GET", aUrl, true);
//        anHttpRequest.send();
//        }
//    }
//
//    var theUrl = 'localhost:8080/game';
//    var client = new HttpClient(theUrl, function(response){
//     clint.get(theUrl, function(response) {
//      var response1 = JSON.parse(response);
//      alert("t");
//      })});



      var getBoard = function() {
        var board = "1";
              var xhr = new XMLHttpRequest(),
                  method = "GET",
                  url = "http://localhost:8080/game";

              xhr.open(method, url, false);
              xhr.onreadystatechange = function () {
                if(xhr.readyState === 4 && xhr.status === 200) {
                  board = (xhr.responseText);
                  console.log(board);
                }
              };
              xhr.send(null);
              if (board == "1"){
              console.log("waiting");

          }
          return board;
        }