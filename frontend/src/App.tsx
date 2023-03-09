import React from 'react';
import './App.css';
import axios from "axios";

function App() {

    const [file, setFile] = React.useState<File | null>(null);
    const [url, setUrl] = React.useState<string>("");

    const handleFileChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        if (event.target.files && event.target.files.length > 0) {
            setFile(event.target.files[0]);
        }
    }

    const handleSubmit = (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        const payload = new FormData();
        if(!file){
            return;
        }
        payload.set('file', file);
        axios.post("/api/photos", payload)
            .then(res => {
                setUrl(res.data)
                console.log(res);
            })
            .catch(err => {
                console.error(err);
            })
    }

    return (
        <div className="App">
            <form onSubmit={handleSubmit}>
                <label>
                    Upload photo:
                    <input type={'file'} onChange={handleFileChange} accept={"image/jpeg, image/png"} />
                </label>
                <button>Upload!</button>
            </form>
            {
                url ? <a href={url}>{url}</a> : ''
            }
        </div>
    );
}

export default App;
