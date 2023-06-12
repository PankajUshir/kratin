import { useEffect, useState } from "react"
import './Expenses.css';
function Expenses() {

    const [doctorBills, setDoctorBills] = useState([]);
    const [yogaTeacherBills, setYogaTeacherBills] = useState([]);
    const [medicineBills, setMedicineBills] = useState([]);
    let total = 0;

    useEffect(() => {
        fetch("http://localhost:8080/doctor/getallbills")
            .then(response => response.json())
            .then(data => setDoctorBills(data))
            .catch(error => console.error('Error fetching API 1:', error))

        fetch("http://localhost:8080/yogateacher/getallbills")
            .then(response => response.json())
            .then(data => setYogaTeacherBills(data))
            .catch(error => console.error('Error fetching API 1:', error))

        fetch("http://localhost:8080/medicine/getallbills")
            .then(response => response.json())
            .then(data => setMedicineBills(data))
            .catch(error => console.error('Error fetching API 1:', error))
    }, [])

    return (
        <div>
            <h1>Current Month Expenses </h1>
            <br />
            <table className="table">
                <th colspan="4">
                    <td>Name</td>
                    <td>Department</td>
                    <td>Date</td>
                    <td>Amount</td>
                </th>

{
    doctorBills.map((element,index) => (
        <tr>
            <td>{element.doctorName}</td>
            <span>{total += element.doctorBillAmount}</span>
            <td>Doctor</td>
            <td>{element.date}</td>
            <td>{element.doctorBillAmount}</td>
        </tr>
        ))
}

{
    yogaTeacherBills.map((element,index) => (
        <tr>
            <td>{element.yogaTeacherName}</td>
            <span>{total += element.yogaTeacherBillAmount};</span>
            <td>Yoga Teacher</td>
            <td>{element.date}</td>
            <td>{element.yogaTeacherBillAmount}</td>
        </tr>
        ))
}

{
    medicineBills.map((element,index) => (
        <tr>
            <td>{element.medicalName}</td>
          <span>{total += element.medicineBillAmount}</span>  
            <td>Medical</td>
            <td>{element.date}</td>
            <td>{element.medicineBillAmount}</td>
        </tr>
        ))
}      
            </table>

            <br />

            <table className="table">
                <tr>
                    <td>Total Amount : </td>
                    <td>{total}</td>
                </tr>
            </table>
        </div>
    )
}
export default Expenses;