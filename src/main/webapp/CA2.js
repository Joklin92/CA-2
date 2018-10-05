const url = "http://localhost:8080/CA-2/";

function makeOptionsGet(requestType, body) {
    return {
        method: requestType,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(body)
    };
};
function makeOptionsPost(requestType, body) {
    return {
        method: requestType,
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(body)
    };
};

function getAllZipcodes(event) {
    let zips = event.target.id;
    
    document.getElementById("choosing").innerHTML = zips;

    console.log("See zips list here here: " + zips)
    url += zips;
    optionsGet;
    fetching();

};

//document.getElementById("givenHobby").addEventListener("click", getPeopleWithGivenHobby);
//document.getElementById("livingInCity").addEventListener("click", getPeopleLivingInCity);
//document.getElementById("countHobbyPeople").addEventListener("click", getCountOfPeopleWithGivenHobby);
document.getElementById("allZipcodes").addEventListener("click", getAllZipcodes);
//document.getElementById("createPerson").addEventListener("click", createPerson);


const dataGet = {

};
const optionsGet = makeOptionsGet("GET", dataGet);

const dataPost = {

};
const optionsPost = makeOptionsPost("POST", dataPost)

const fetching = fetch(url, optionsGet)
    .then(handleHttpErrors)
    .then(json => console.log(json))
    .then(function (data) {
        let dataFound = data.results;
        return dataFound.map(function (mapData) {
            let n = [mapData].join(", ");
            return n;
        })
    })
    .catch(error => {
        if (error.status) {
            error.error.then(e => console.log(e))
        }
        else {
            console.log("Network error");
        }
    });

function handleHttpErrors(response) {
    if (!response.ok) {
        return Promise.reject({ status: response.status, error: response.json() })
    }
    return response.json();
}

function handleHttpErrors(response) {
    if (!response.ok) {
        return Promise.reject({ status: response.status, error: response.json() })
    }
    return response.json();
}