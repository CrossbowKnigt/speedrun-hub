import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import { HeroUIProvider } from '@heroui/react'
import { BrowserRouter, Routes, Route } from "react-router";
import './index.css'
import MarathonPage from './routes/MarathonPage.tsx';
import MarathonLayout from './routes/MarathonLayout.tsx';
import MarathonForm from './routes/MarathonForm.tsx';

createRoot(document.getElementById('root')!).render(
  <StrictMode>
    <HeroUIProvider>
      <BrowserRouter>
        <Routes>
          <Route element={<MarathonLayout />}>
            <Route path='marathons'>
              <Route index element={<MarathonPage />} />
              <Route path='new' element={<MarathonForm />} />
              <Route path='edit' element={<MarathonForm />} />
            </Route>

          </Route>
        </Routes>
      </BrowserRouter>
    </HeroUIProvider>
  </StrictMode>,
)
