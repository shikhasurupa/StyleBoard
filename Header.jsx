import React from "react";
import {
  StyledHeader,
  LogoContainer,
  LinkContainer,
  StyledLink,
  AuthButtonsContainer,
  AuthButton,
  LogoImage,
} from "./Header.styled";
import { Text } from "../../utils/Text.styled";
import styleboard from "../../assets/styleboard2.png"




const Header = () => {
  return (
    <StyledHeader>
      <LogoContainer>
      
        <LogoImage 
            src={styleboard}
            alt="Styleboard Logo"
        />
        {/* <Text color="#E60022" size="large" className="logo" as="h1">
          STYLEBOARD
        </Text> */}
      </LogoContainer>
      <LinkContainer>
     
        <StyledLink> Home</StyledLink>
        <StyledLink>Collections</StyledLink>
        <AuthButtonsContainer>
          <AuthButton type="logOutTextColor">Log Out </AuthButton>
        </AuthButtonsContainer>
      </LinkContainer>
    </StyledHeader>
  );
};

export default Header;
