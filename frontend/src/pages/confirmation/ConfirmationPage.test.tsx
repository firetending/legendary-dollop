import React from 'react';
import { render, screen } from '@testing-library/react';
import ConfirmationPage from './ConfirmationPage';

test('renders learn react link', () => {
  render(<ConfirmationPage />);
  const linkElement = screen.getByText(/learn react/i);
  expect(linkElement).toBeInTheDocument();
});