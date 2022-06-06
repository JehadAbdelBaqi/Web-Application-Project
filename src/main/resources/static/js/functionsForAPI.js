'use strict';

const ADDR = "http://localhost:8080/customer";

// Divs
const readAllDiv = document.querySelector("#results");
const updateFormDiv = document.querySelector("#updateForm");

// Buttons
const createBtn = document.querySelector("#createBtn");
const resetBtn = document.querySelector("#resetBtn");
const submitBtn = document.querySelector("#submitBtn");

// Inputs
const FIRSTNAME = document.querySelector("#firstName");
const LASTNAME = document.querySelector("#lastName");
const ADDRESS = document.querySelector("#address");
const UPDFIRSTNAME = document.querySelector("#updateFirstName");
const UPDLASTNAME = document.querySelector("#updateLastName");
const UPDADDRESS = document.querySelector("#updateAddress");


// Setup
const setUp = () => {
    getRequest();
}

const getRequest = () => {
    axios.get(`${ADDR}/getAll`)
        .then(
            (res) => {
                displayResult(res.data);
            }
        )
        .catch(
            (err) => {
                console.error(err);
            }
        )
}

const displayResult = (data) => {
    readAllDiv.innerHTML = "";
    for (let entry of data) {
        const entryDiv = document.createElement("div");
        const editBtn = document.createElement("button");
        const deleteBtn = document.createElement("button");
        const editBtnText = document.createTextNode("Edit");
        const deleteBtnText = document.createTextNode("Delete");
        const textOfResults = document.createTextNode(`${entry.firstName} ${entry.lastName} of ${entry.address}`);

        entryDiv.setAttribute("class", "entryDiv");
        editBtn.setAttribute("class", "editButton");
        editBtn.setAttribute("id", "editBtn");
        editBtn.setAttribute("value", `${entry.id}`);
        deleteBtn.setAttribute("class", "deleteButton");
        deleteBtn.setAttribute("id", "deleteButton");
        deleteBtn.setAttribute("value", `${entry.id}`);

        deleteBtn.appendChild(deleteBtnText);
        editBtn.appendChild(editBtnText);
        entryDiv.appendChild(editBtn);
        entryDiv.appendChild(textOfResults);
        entryDiv.appendChild(deleteBtn);
        readAllDiv.appendChild(entryDiv);

        deleteBtn.addEventListener("click", function () { deleteById(entry.id); });
        editBtn.addEventListener("click", function () { update(entry.id); });
    }
}

const create = () => {

    const FIRSTNAME_VALUE = FIRSTNAME.value;
    const LASTNAME_VALUE = LASTNAME.value;
    const ADDRESS_VALUE = ADDRESS.value;

    let obj = {
        "firstName": FIRSTNAME_VALUE,
        "lastName": LASTNAME_VALUE,
        "address": ADDRESS_VALUE,
    }

    axios.post(`${ADDR}/create`, obj)
        .then(
            (res) => {
                getRequest();
                FIRSTNAME.value = "";
                LASTNAME.value = "";
                ADDRESS.value = "";
            }
        )
        .catch(
            (err) => {
                console.log(err);
            }
        )
}

const deleteById = (id) => {
    axios.delete(`${ADDR}/delete/${id}`)
        .then(
            (res) => {
                getRequest();
            }
        )
        .catch(
            (err) => {
                console.log(err);
            }
        )
}

let update = (id) => {

    document.querySelector(".bg-modal").style.display = "flex";

    document.querySelector(".close").addEventListener("click", function () {
        document.querySelector(".bg-modal").style.display = "none";
        UPDFIRSTNAME.value = "";
        UPDLASTNAME.value = "";
        UPDADDRESS.value = "";
    });

    submitBtn.addEventListener("click", function () {
        const UPDFIRSTNAME_VALUE = UPDFIRSTNAME.value;
        const UPDLASTNAME_VALUE = UPDLASTNAME.value;
        const UPDADDRESS_VALUE = UPDADDRESS.value;

        let updObj = {
            "firstName": UPDFIRSTNAME_VALUE,
            "lastName": UPDLASTNAME_VALUE,
            "address": UPDADDRESS_VALUE,
        }
        axios.put(`${ADDR}/update/${id}`, updObj)
            .then(
                (res) => {
                    getRequest();
                    document.querySelector(".bg-modal").style.display = "none";
                    UPDFIRSTNAME.value = "";
                    UPDLASTNAME.value = "";
                    UPDADDRESS.value = "";
                }
            )
            .catch(
                (err) => {
                    console.log(err);
                    document.querySelector(".bg-modal").style.display = "none";
                }
            )
    })
}

let resetValues = () => {
    FIRSTNAME.value = "";
    LASTNAME.value = "";
    ADDRESS.value = "";
}

createBtn.addEventListener("click", create);
resetBtn.addEventListener("click", resetValues);
