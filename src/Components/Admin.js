import React, { useState, useEffect } from 'react';
import axios from 'axios';

function DataTable() {
  const [data, setData] = useState([]);

  useEffect(() => {
    loadData();
  }, []);

  function loadData() {
    axios.get('http://localhost:8080/student/get/all')
      .then(response => {
        setData(response.data);
      })
      .catch(error => console.error(error));
  }

  function handleApprove(studentId) {
    axios.put(`http://localhost:8080/admin/approve/${studentId}`, { status: 'approved' })
      .then(response => {
        loadData(); // Reload data after action
      })
      .catch(error => console.error(error));
  }

  function handleReject(studentId) {
    axios.put(`http://localhost:8080/admin/reject/${studentId}`, { status: 'rejected' })
    .then(response => {
      loadData(); // Reload data after action
    })
    .catch(error => console.error(error));
  }

  return (
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Email</th>
          <th>Offer Letter</th>
          <th>Action</th>
        </tr>
      </thead>
      <tbody>
        {data.map(item => (
          <tr key={item.studentId}>
            <td>{item.studentId}</td>
            <td>{item.firstName}</td>
            <td>{item.lastName}</td>
            <td>{item.email}</td>
            <td><img src={item.offerLetter} alt="User avatar" /></td>
            <td>
              <button onClick={() => handleApprove(item.studentId)}>Approve</button>
              <button onClick={() => handleReject(item.studentId)}>Reject</button>
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

export default DataTable;
