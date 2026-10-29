import React, { useEffect, useState } from 'react'

function SampleCode({ empdata }) {
    const [counter, setCounter] = useState(10);
    const [pointer, setPointer] = useState(20);
    useEffect(() => {
        console.log("Rendered Component"+counter); 
        console.log("Rendered pointer"+pointer); 
        // console.log("counter="+counter); 
    },[pointer])

    function changeCounter() {
        setCounter(counter +2);
    }


    function changePointer() {
        setPointer(pointer - 2);
    }

  return (
    <div>
      <h2>Counter Value={counter}</h2>
      <h2>Pointer Value={pointer}</h2>
      <button onClick={changeCounter}>Counter</button>
      <button onClick={changePointer}>Pointer</button>
      {/* <h2>Employee Details</h2>
      <div style={{border:'2px solid white',height:'250px',width:'200px', alignItems:'center', justifyContent:'center', marginLeft:'450px'} }> 
        <h3> Name:{empdata.ename}</h3>
        <h3> Name:{empdata.empid}</h3>
      </div> */}
    </div>
  );
}

export default SampleCode