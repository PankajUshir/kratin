import { useState } from "react";

function Checkup() {
    let [sugar, setSugar] = useState(0);
    let [bp, setBp] = useState(0);
    const [msg,setMsg] = useState("");
    const [msgBp,setMsgBp] = useState("");
    const [meal,setMeal] = useState();

    let checkSugar = () => {
        if(sugar>=80 && sugar<=130 && meal == 1){//before a meal
            setMsg("Normal Sugar")
        }
        else if(bp>=120 && bp<=180 && meal == 0){//after a meal
            setMsgBp("Normal Sugar")
        }
        else{
            setMsg("Please consult your doctor")
        }
    }

    let checkBloodPressure = ()=>{
        if(bp>=80 && bp<=130){
            setMsgBp("Normal Sugar")
        }
        else{
            setMsgBp("Please consult your doctor")
        }
    }

    return (
        <div>
                <table>
                    <tr>
                        <td>Blood Sugar : </td>
                        <td><input type="number" onChange={(e)=>setSugar(e.target.value)} /></td>
                    </tr>

                    <tr>
                        <td></td>
                        <td><button onClick={checkSugar}>Check Sugar Level</button></td>
                    </tr>
                </table>
                <h1>{msg}</h1>
                <br/>
                <hr/>
                <br/>
                <table>
                    <tr>
                        <td>Blood Pressure : </td>
                        <td><input type="number" onChange={(e)=>setBp(e.target.value)} /></td>
                        <td>
                            <select onChange={(e)=>{setMeal(e.target.value)}}>
                                <option value="">Select an Option</option>
                                <option value="1">Before a Meal</option>
                                <option value="0">After a Meal</option>
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td></td>
                        <td><button onClick={checkBloodPressure}>Check Blood Pressure Level</button></td>
                    </tr>
                </table>
                <h1>{msgBp}</h1>
        </div>
    )
}

export default Checkup;