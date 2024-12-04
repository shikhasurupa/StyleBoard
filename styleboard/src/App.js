import logo from './logo.svg';
import './App.css';
import LoginRegister from './Component/LoginRegister/LoginRegister';
import Feed from './Component/Feed/FeedScreen';
import CollectionPage from './Component/CollectionDummy';
import { Routes, Route} from 'react-router-dom'

function App() {
  return (
    <div>
      <Routes>
        <Route path='/' element={<LoginRegister />} />
        <Route path='/feed' element={<Feed />} />
        <Route path='/collections' element={<CollectionPage />} />
      </Routes>
    </div>
  );
}

export default App;
