let url = "http://localhost:8084/CA-2/"; // change after deployment

document.getElementById("allZipCodes").addEventListener("click", getAllZipcodes);
document.getElementById("allPerson").addEventListener("click", getAllPersons);
document.getElementById("contactinfo").addEventListener("click", getContactInfo);
document.getElementById("universalSubmit").addEventListener("click", universalInput);



function getAllZipcodes() {
    
    url += "api/cityinfo/allZips";
    console.log(url);     
    function tablerow(element) {
        let row = `<tr><td>${element}</td></tr>`
        return row;
    }
   
    fetcher(url, json => {
        document.getElementById("tblbody").innerHTML = json.map(tablerow).join("");
        url = "http://localhost:8084/CA-2/" //clears url for further use
    });
};

function getAllPersons() {
    
    url += "api/person/complete";
    console.log(url);     
    function tablerow(element) {
        let row = `<tr><td>${element.fullName}</td><td>${element.phone}</td></tr>`
        return row;
    }
   
    fetcher(url, json => {
        document.getElementById("tblbody").innerHTML = json.map(tablerow).join("");
        url = "http://localhost:8084/CA-2/"
    });
};

function getContactInfo() {
    
    url += "api/person/contactinfo";
    console.log(url);     
    function tablerow(element) {
        let row = `<tr><td>${element.fullName}</td><td>${element.address}</td><td>${element.phone}</td></tr>`
        return row;
    }
   
    fetcher(url, json => {
        document.getElementById("tblbody").innerHTML = json.map(tablerow).join("");
        url = "http://localhost:8084/CA-2/"
    });
};

function getPersonById() {
    var result = document.getElementById("universalInput").value;
    url += "api/person/"+result;
    console.log(url);  
   
    fetcher(url, json => {
        document.getElementById("tblbody").innerHTML = json.fullName + " " + json.phone;
        url = "http://localhost:8084/CA-2/" //clears url for further use
    });
};

function getPersonByPhone() {
    var result = document.getElementById("universalInput").value;
    url += "api/person/phone/"+result;
    console.log(url); 
   
    fetcher(url, json => {
        document.getElementById("tblbody").innerHTML = json.fullName + " " + json.phone;
        url = "http://localhost:8084/CA-2/" //clears url for further use
    });
};

function getPersonById() {
    var result = document.getElementById("universalInput").value;
    url += "api/person/"+result;
    console.log(url);  
   
    fetcher(url, json => {
        document.getElementById("tblbody").innerHTML = json.fullName + " " + json.phone;
        url = "http://localhost:8084/CA-2/" //clears url for further use
    });
};

function getCityByZip() {
    var result = document.getElementById("universalInput").value;
    url += "api/cityinfo/"+result;
    console.log(url);  
   
    fetcher(url, json => {
        document.getElementById("tblbody").innerHTML = json.zipCode + " " + json.city;
        url = "http://localhost:8084/CA-2/" //clears url for further use
    });
};

function universalInput() {
    var result = document.getElementById("universalInput").value;
    if(result.length < 4) {
        getPersonById();
    } else if(result.length < 8) {
        getCityByZip();
    }else {
        getPersonByPhone();
    }
}

function callback(request) {
    console.log(JSON.parse(request.responseText));
}


const fetcher = (url, callback) => {

fetch(url)
            .then(function (response) {            
                    return response.json();
            })
            .then(function (json) {
                callback(json);
            })}