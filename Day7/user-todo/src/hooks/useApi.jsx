import { useState } from 'react';

export function useApi() {
  const [data, setData] = useState(null);
  const [error, setError] = useState(null);

  const getToken = () => {
    const hasUser = localStorage.getItem('user');
    if (hasUser) {
      const user = JSON.parse(hasUser);
      return user.accessToken;
    }
    return '';
  };

  const postData = (url, payload = {}, method = 'POST') => {
    let token = getToken();

    fetch(url, {
      method: method,
      headers: {
        'Content-Type': 'application/json',
        Authorization: `Bearer ${token}`,
      },
      body: JSON.stringify(payload),
    })
      .then((res) => res.json())
      .then((data) => {
        setData(data);
      })
      .catch((error) => {
        setError(error);
      });
  };

  const getData = (url, method = 'GET') => {
    let token = getToken();

    fetch(url, {
      method: method,
      headers: {
        Authorization: `Bearer ${token}`,
      },
    })
      .then((res) => res.json())
      .then((data) => {
        setData(data);
      })
      .catch((error) => {
        setError(error);
      });
  };

  return { data, error, setError, postData, getData };
}
